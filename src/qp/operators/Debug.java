package qp.operators;

import java.util.Date;

import qp.utils.Attribute;
import qp.utils.Batch;
import qp.utils.Condition;
import qp.utils.Schema;
import qp.utils.Tuple;

/**
 * Defines some helper functions which can be useful for debugging &
 * troubleshooting purposes (such as printing).
 */
public class Debug {
    /**
     * Pretty-prints a given attribute.
     *
     * @param attr is the attribute to be printed.
     */
    public static void PPrint(Attribute attr) {
        String tabName = attr.getTabName();
        String colName = attr.getColName();
        System.out.print(tabName + "." + colName);
    }

    /**
     * Pretty-prints a given condition.
     *
     * @param con is the condition to be printed.
     */
    public static void PPrint(Condition con) {
        Attribute lhs = con.getLeft();
        Object rhs = con.getRight();
        int expressionType = con.getOperator();

        // Prints the lef-hand side of the condition first.
        PPrint(lhs);

        // Prints the operator next.
        switch (expressionType) {
            case Condition.LESS_THAN:
                System.out.print("<");
                break;
            case Condition.GREATER_THAN:
                System.out.print(">");
                break;
            case Condition.LTOE:
                System.out.print("<=");
                break;
            case Condition.GTOE:
                System.out.print(">=");
                break;
            case Condition.EQUAL:
                System.out.print("==");
                break;
            case Condition.NOTEQUAL:
                System.out.print("!=");
                break;
        }

        // Prints the right-hand side in the end.
        if (con.getCondType() == Condition.JOIN) {
            PPrint((Attribute) rhs);
        } else if (con.getCondType() == Condition.SELECT) {
            System.out.print((String) rhs);
        }
    }

    /**
     * Pretty-prints a given schema.
     *
     * @param schema is the schema to be printed.
     */
    public static void PPrint(Schema schema) {
        System.out.println();

        // Prints each attribute in the schema.
        for (int i = 0; i < schema.getNumCols(); i++) {
            Attribute attr = schema.getAttribute(i);
            PPrint(attr);
        }

        System.out.println();
    }

    /**
     * Pretty-prints a given node in a plan execution tree.
     *
     * @param node is the node to be printed.
     */
    public static void PPrint(Operator node) {
        int operatorType = node.getOpType();
        switch (operatorType) {
            case OpType.JOIN:
                int expressionType = ((Join) node).getJoinType();
                switch (expressionType) {
                    case JoinType.PAGE_NESTED_JOIN:
                        System.out.print("PageNestedJoin(");
                        break;
                    case JoinType.BLOCK_NESTED_JOIN:
                        System.out.print("BlockNestedJoin(");
                        break;
                    case JoinType.SORT_MERGE_JOIN:
                        System.out.print("SortMergeJoin(");
                        break;
                    case JoinType.HASH_JOIN:
                        System.out.print("HashJoin(");
                        break;
                    case JoinType.INDEX_NESTED_JOIN:
                        System.out.print("IndexNestedJoin(");
                        break;
                }
                PPrint(((Join) node).getLeft());
                System.out.print("  [");
                PPrint(((Join) node).getCondition());
                System.out.print("]  ");
                PPrint(((Join) node).getRight());
                System.out.print(")");
                break;
            case OpType.SELECT:
                System.out.print("Select(");
                PPrint(((Select) node).getBase());
                System.out.print("  '");
                PPrint(((Select) node).getCondition());
                System.out.print("'  ");
                System.out.print(")");
                break;
            case OpType.PROJECT:
                System.out.print("Project(");
                PPrint(((Project) node).getBase());
                System.out.print(")");
                break;
            case OpType.DISTINCT:
                System.out.print("Distinct(");
                PPrint(((Distinct) node).getBase());
                System.out.print(")");
                break;
            case OpType.GROUPBY:
                System.out.print("GroupBy(");
                PPrint(((Groupby) node).getBase());
                System.out.print(")");
                break;
            case OpType.SCAN:
                System.out.print(((Scan) node).getTableName());
                break;
        }
    }

    /**
     * Pretty-prints a given tuple.
     *
     * @param t is the tuple to be printed.
     */
    public static void PPrint(Tuple t) {
        for (int i = 0; i < t.getData().size(); i++) {
            Object data = t.dataAt(i);
            if (data instanceof Integer) {
                System.out.print(((Integer) data).intValue() + "\t");
            } else if (data instanceof Float) {
                System.out.print(((Float) data).floatValue() + "\t");
            } else if (data instanceof Date) {
                System.out.print(((Date) data).getTime() + "\t");
            } else {
                System.out.print(((String) data) + "\t");
            }
        }
        System.out.println();
    }

    /**
     * Pretty-prints a page of tuples.
     *
     * @param b is the batch of tuples (i.e., one page).
     */
    public static void PPrint(Batch b) {
        for (int i = 0; i < b.size(); i++) {
            PPrint(b.elementAt(i));
            System.out.println();
        }
    }
}
