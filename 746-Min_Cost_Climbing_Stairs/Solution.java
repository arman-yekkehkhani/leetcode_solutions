/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 43.09 MB (beats 44.41 %)
 * tags: dynamic programming, arrays
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // subProbs: min cost of going to top from stair i
        // relation: mc(i) = cost[i] + min{mc(i + 1), mc(i + 2)}
        // Topological Order:
        // Basecase: i == cost.length -> mc = 0;
        // Original mc(0)
        // TimeAnalysis: O(n) * O(1) = O(n)

        int[] mc = new int[cost.length + 2];
        mc[mc.length - 1] = 0;
        mc[mc.length - 2] = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            mc[i] = cost[i] + Math.min(mc[i + 1], mc[i + 2]);
        }
        return Math.min(mc[0], mc[1]);
    }
}

