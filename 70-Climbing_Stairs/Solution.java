/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 39.98 MB (beats 88.34 %)
 * tags: dynamic programming, memoization
 */

class Solution {
    int[] memo = new int[46];

    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] == 0) {
            memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }
        return memo[n];
    }
}
