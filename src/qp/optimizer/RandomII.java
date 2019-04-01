package qp.optimizer;

import qp.operators.Operator;
import qp.utils.SQLQuery;

/**
 * Defines a randomized query optimizer using the Iterative Improvement (II) algorithm.
 */
public class RandomII extends RandomOptimizer {
    /**
     * Constructor of RandomOptimizer.
     *
     * @param sqlQuery is the SQL query to be optimized.
     */
    public RandomII(SQLQuery sqlQuery) {
        super(sqlQuery);
    }

    /**
     * Implements Iterative Improvement Algorithm or Randomized optimization of Query Plan.
     *
     * @return the optimized plan.
     */
    public Operator getOptimizedPlan() {
        // Gets an initial plan for the given sql query.
        RandomInitialPlan rip = new RandomInitialPlan(sqlQuery);
        numOfJoin = rip.getNumJoins();

        // The final plan.
        Operator finalPlan = null;
        int finalCost = Integer.MAX_VALUE;

        // Premature exits if there is no join in the query.
        if (numOfJoin == 0) {
            finalPlan = rip.prepareInitialPlan();
            printPlanCostInfo("Final Plan", finalPlan);
            return finalPlan;
        }

        // Randomly restarts the gradient descent algorithm for a specified number of times.
        for (int j = 0; j < 2 * numOfJoin; j++) {
            Operator initPlan = rip.prepareInitialPlan();
            Transformations.modifySchema(initPlan);
            int initCost = printPlanCostInfo("Initial Plan", initPlan);

            // A flag to determine whether we have reached local minimum.
            boolean flag = true;

            // Just for initialization purpose.
            Operator minNeighborPlan = initPlan;
            int minNeighborCost = initCost;

            while (flag) {
                System.out.println("---------------while---------------");
                // In this loop we consider from the possible neighbors (randomly selected)
                // and take the minimum among for next step.
                for (int i = 0; i < 2 * numOfJoin; i++) {
                    Operator initPlanCopy = (Operator) initPlan.clone();
                    Operator neighbor = getNeighbor(initPlanCopy);
                    int neighborCost = printPlanCostInfo("Neighbor", neighbor);

                    if (neighborCost < minNeighborCost) {
                        minNeighborPlan = neighbor;
                        minNeighborCost = neighborCost;
                    }
                }

                if (minNeighborCost < initCost) {
                    initPlan = minNeighborPlan;
                    initCost = minNeighborCost;
                } else {
                    minNeighborPlan = initPlan;
                    minNeighborCost = initCost;

                    // Reaches local minimum.
                    flag = false;
                }
            }

            printPlanCostInfo("Local Minimum", minNeighborPlan, minNeighborCost);
            if (minNeighborCost < finalCost) {
                finalCost = minNeighborCost;
                finalPlan = minNeighborPlan;
            }
        }
        printPlanCostInfo("Final Plan", finalPlan, finalCost);

        return finalPlan;
    }
}
