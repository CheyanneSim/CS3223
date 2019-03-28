package qp.operators;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import qp.utils.Attribute;
import qp.utils.Batch;
import qp.utils.Schema;
import qp.utils.Tuple;

/**
 * Applies external sort on a given relation.
 */
public class Sort extends Operator {
    // The base operator (i.e., the unsorted relation).
    private final Operator base;
    // The number of buffer pages available.
    private final int numOfBuffers;
    // The index of the attribute to sort based on.
    private final int sortKeyIndex;
    // The data type of the attribute to sort based on.
    private final int sortKeyType;
    // The number of tuples per batch.
    private final int batchSize;

    /**
     * Creates a new sort operator.
     *
     * @param base is the base operator.
     * @param numOfBuffers is the number of buffers (in pages) available.
     */
    public Sort(Operator base, Attribute sortKey, int numOfBuffers) {
        super(OpType.SORT);
        this.schema = base.schema;

        this.base = base;
        this.sortKeyIndex = schema.indexOf(sortKey);
        this.sortKeyType = schema.getAttribute(sortKeyIndex).getType();
        this.numOfBuffers = numOfBuffers;
        this.batchSize = Batch.getPageSize() / schema.getTupleSize();
    }

    @Override
    public boolean open() {
        // Makes sure the base operator can open successfully first.
        if (!base.open()) {
            return false;
        }

        // Phase 1: generate sorted runs using in-memory sorting algorithms.
        int numOfRuns = generateSortedRuns();
        // Phase 2: merge sorted runs together (could be in multiple passes).
        return mergeRuns(numOfRuns) == 1;
    }

    /**
     * Generates sorted runs and stores them to disk. Currently, we utilize all buffer pages available
     * and thus minimizes the number of runs generated.
     *
     * @return the number of sorted runs generated.
     */
    private int generateSortedRuns() {
        // Reads in the next page from base operator.
        Batch inBatch = base.next();

        int numOfRuns = 0;
        while (inBatch != null) {
            // Stores the tuples that will be in the current run.
            Vector<Tuple> tuplesInRun = new Vector<>();

            // Reads in as many tuples as possible (until either there is no more tuples or reaches buffer limit).
            for (int i = 0; i < numOfBuffers && inBatch != null; i++) {
                tuplesInRun.addAll(inBatch.getTuples());
                inBatch = base.next();
            }

            // Sorts the tuples using in-memory sorting algorithms.
            tuplesInRun.sort(this::compareTuples);

            // Stores the sorted result into disk.
            String fileName = getSortedRunFileName(numOfRuns);
            try {
                ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fileName));
                // TODO: do we need to write each batch to a single file?
                stream.writeObject(tuplesInRun);
                stream.close();
            } catch (IOException e) {
                System.err.println("Sort: unable to write sortedRun with ID=" + numOfRuns + " due to " + e);
                System.exit(1);
            }

            // Reads in another page and prepares for the next iteration.
            inBatch = base.next();
            numOfRuns++;
        }

        return numOfRuns;
    }

    /**
     * Merges a given number of sorted runs in a manner similar to merge-sort. Here we use all available
     * buffers to minimize the number of passes.
     *
     * @param numOfRuns is the number of sorted runs to be merged.
     * @return the number of sorted runs after one round of merge.
     */
    private int mergeRuns(int numOfRuns) {
        // Exits if there is no more than 1 run (which means there is no need to merge anymore).
        if (numOfRuns <= 1) {
            return numOfRuns;
        }

        // Uses (numOfBuffers - 1) as input buffers, and the left one as output buffer.
        int numOfOutputRuns = 0;
        for (int startRunID = 0; startRunID < numOfRuns; startRunID = startRunID + numOfBuffers - 1) {
            int endRunID = Math.min(startRunID + numOfBuffers - 1, numOfRuns);
            mergeRunsBetween(startRunID, endRunID);
            numOfOutputRuns++;
        }

        // Continues to the next round using a recursive call.
        return mergeRuns(numOfOutputRuns);
    }

    /**
     * Merges the sorted runs in the range of [startRunID, endRunID). Since we have a fix number of buffer
     * pages, we assume endRunID - startRunID <= numOfBuffers - 1.
     *
     * @param startRunID is the sorted run ID of the lower bound (inclusive).
     * @param endRunID is the sorted run ID of the upper bound (exclusive).
     *
     * @implNote we effectively implement a k-way merge sort here.
     */
    private void mergeRunsBetween(int startRunID, int endRunID) {
        // Each input sorted run has 1 buffer page.
        Batch[] inBatches = new Batch[endRunID - startRunID];
        // Each input sorted run has one stream to read from.
        ObjectInputStream[] inStreams = new ObjectInputStream[endRunID - startRunID];
        // Only 1 buffer page for output.
        Batch outBatch = new Batch(batchSize);

        // Establishes the streams and reads the first pages of each input sorted run.
        for (int i = 0; i < endRunID - startRunID; i++) {

        }
    }

    /**
     * Compares two tuples based on the sort attribute.
     *
     * @param tuple1 is the first tuple.
     * @param tuple2 is the second tuple.
     * @return an integer indicating the comparision result, compatible with the {@link java.util.Comparator} interface.
     */
    private int compareTuples(Tuple tuple1, Tuple tuple2) {
        Object value1 = tuple1.dataAt(sortKeyIndex);
        Object value2 = tuple2.dataAt(sortKeyIndex);

        switch (sortKeyType) {
            case Attribute.INT:
                return Integer.compare((int) value1, (int) value2);
            case Attribute.STRING:
                return ((String) value1).compareTo((String) value2);
            case Attribute.REAL:
                return Float.compare((float) value1, (float) value2);
            default:
                return 0;
        }
    }

    /**
     * Provides the file name of a generated sorted run based on its run ID.
     *
     * @param runID is the ID of the sorted run.
     */
    private String getSortedRunFileName(int runID) {
        return "Sort-run-" + runID;
    }
}
