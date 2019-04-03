package qp.optimizer;

import qp.operators.Operator;
import qp.utils.RandomNum;
import qp.utils.SQLQuery;

/**
 * Defines a randomized query optimizer using the Simulated Annealing (SA) algorithm.
 */
public class RandomSA extends RandomOptimizer {
    private static final int INIT_TEMPERATURE_PARAMETER = 2;
    private static final double END_TEMPERATURE = 1;
    private static final double ALPHA = 0.85;

    /**
     * Constructor of RandomOptimizer.
     *
     * @param sqlQuery is the SQL query to be optimized.
     */
    public RandomSA(SQLQuery sqlQuery) {
        super(sqlQuery);
    }

    /**
     * Implements an simulated annealing algorithm for query plan.
     *
     * @return the optimized plan.
     */
    @Override
    public Operator getOptimizedPlan() {
        // Gets an initial plan for the given sql query.
        RandomInitialPlan rip = new RandomInitialPlan(sqlQuery);
        numOfJoin = rip.getNumJoins();

        // The current & final plan.
        Operator minPlan = rip.prepareInitialPlan();
        Transformations.modifySchema(minPlan);
        int minCost = printPlanCostInfo("Initial Plan", minPlan);

        // Premature exits if there is no join in the query.
        if (numOfJoin == 0) {
            printPlanCostInfo("Final Plan", minPlan);
            return minPlan;
        }

        // Continues until the temperature has dropped below a certain threshold (i.e., frozen).
        boolean isFirstRound = true;
        for (double temperature = minCost * INIT_TEMPERATURE_PARAMETER; temperature > END_TEMPERATURE; temperature *= ALPHA) {
            Operator initPlan = minPlan;
            int initCost = minCost;

            // Performs a random restart for more randomness (except for the 1st round).
            if (!isFirstRound) {
                System.out.println("\n====================================================================================================");
                initPlan = rip.prepareInitialPlan();
                Transformations.modifySchema(initPlan);
                initCost = printPlanCostInfo("Initial Plan", initPlan);
            }
            isFirstRound = false;

            // Continues until we reach equilibrium.
            for (int i = 0; i < 8 * numOfJoin; i++) {
                Operator initPlanCopy = (Operator) initPlan.clone();
                Operator currentPlan = getNeighbor(initPlanCopy);
                int currentCost = printPlanCostInfo("Neighbor", currentPlan);

                if (currentCost <= initCost || judge(temperature, currentCost, initCost)) {
                    System.out.printf("Switched to another plan, initCost changes from %d to %d\n", initCost, currentCost);
                    initPlan = currentPlan;
                    initCost = currentCost;
                }
            }

            // Tries to update the global optimal solution if necessary.
            printPlanCostInfo("Local Minimum", initPlan, initCost);
            if (initCost < minCost) {
                System.out.printf("Applied minimum from the current round, minCost changes from %d to %d\n", minCost, initCost);
                minPlan = initPlan;
                minCost = initCost;
            }
        }

        printPlanCostInfo("Final Plan", minPlan, minCost);
        return minPlan;
    }

    /**
     * Judges whether we accept this uphill move according to the annealing probability function.
     *
     * @param temperature is the current annealing temperature.
     * @param value1 is the first value.
     * @param value2 is the second value.
     * @return true if we should accept this move.
     */
    private boolean judge(double temperature, int value1, int value2) {
        int delta = Math.abs(value1 - value2);
        double prob = Math.exp(-delta / temperature);
        return RandomNum.randDouble() < prob;
    }
}
