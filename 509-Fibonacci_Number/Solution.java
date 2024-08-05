/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 40.78 MB (beats 5.77 %)
 * tags: dynamic programming, array, hash
 */

class Solution {
    int[] cache = new int[30];

    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        if (cache[n - 1] == 0) {
            cache[n - 1] = fib(n - 1);
        }
        return cache[n - 1] + cache[n - 2];
    }
}
