/**
 * Author: Arman Yekkehkhani
 * Runtime: 12ms (beats 97.12%)
 * Memory: 45.34 MB (beats 98.67%)
 * tags: hash, rolling hash, bit manipulation
 */

class Solution {

  public boolean hasAllCodes(String s, int k) {
    if (s.length() <= k) {
      return false;
    }

    boolean[] h = new boolean[1 << k];
    int n = Integer.parseInt(s, s.length() - k, s.length(), 2);
    h[n] =  true;

    for (int i = s.length() -  k - 1; i >= 0; i--) {
      n = ((s.charAt(i) - 48) << (k - 1)) + (n >> 1);
      h[n] = true;
    }

    for (boolean b : h) {
      if (!b) {
        return false;
      }
    }
    return true;
  }
}