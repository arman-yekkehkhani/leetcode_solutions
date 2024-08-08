/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 39.97 MB (beats 88.21 %)
 * tags: dynamic programming, fibonacci
 */

class Solution {
    int[] vals = new int[38];

    {
        vals[1] = 1;
        vals[2] = 1;
    }

    public int tribonacci(int n) {
        if (n == 0) return n;
        if (vals[n] == 0) {
            vals[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        }
        return vals[n];
    }
}

