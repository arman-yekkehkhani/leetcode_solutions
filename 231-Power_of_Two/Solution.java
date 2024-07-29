/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 40.46 MB (beats 85.00 %)
 * tags: 
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        n = n & (n - 1); // removes the rightmost 1-bit
        return n == 0;
    }
}
