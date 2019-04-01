package qp.optimizer;

import qp.operators.Operator;
import qp.utils.RandomNum;
import qp.utils.SQLQuery;

/**
 * Defines a randomized query optimizer using the Simulated Annealing (SA) algorithm.
 */
public class RandomSA extends RandomOptimizer {
    private static final double END_TEMPERATURE = 1;
    private static final double ALPHA = 0.8;

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
        int minCost = Integer.MAX_VALUE;
        double temperature = numOfJoin * 2;

        // Premature exits if there is no join in the query.
        if (numOfJoin == 0) {
            printPlanCostInfo("Final Plan", minPlan);
            return minPlan;
        }

        // Continues until the temperature has dropped below a certain threshold (i.e., frozen).
        while (temperature > END_TEMPERATURE) {
            Operator initPlanCopy = (Operator) minPlan.clone();
            Operator currentPlan = getNeighbor(initPlanCopy);
            int currentCost = printPlanCostInfo("Neighbor", currentPlan);

            if (currentCost <= minCost || judge(temperature, currentCost, minCost)) {
                minPlan = currentPlan;
                minCost = currentCost;
            }

            // Reduces the temperature.
            temperature *= ALPHA;
        }

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
