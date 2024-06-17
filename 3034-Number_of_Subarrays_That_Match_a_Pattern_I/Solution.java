/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 100%)
 * Memory: 44.68 MB (beats 15.20%)
 * tags: hash, rolling hash
 */

class Solution {
  public int countMatchingSubarrays(int[] nums, int[] p) {
    int hp = hash(p, 0, p.length);

    int[] tr = new int[nums.length - 1];
    for (int i = 1; i < nums.length; i++) {
      int s = 0;
      if (nums[i] > nums[i - 1]) {
        s = 1;
      }
      if (nums[i] < nums[i - 1]) {
        s = -1;
      }
      tr[i - 1] = s;
    }

    int h = 0;
    int c = 0;
    for (int i = 0; i < tr.length; i++) {
      h += tr[i];
      if (i >= p.length) {
        h -= tr[i - p.length];
      }
      if (i >= p.length - 1 && h == hp) {
        boolean match = true;
        for (int j = 0; j < p.length; j++) {
          if (tr[i - j] != p[p.length - j - 1]) {
            match = false;
            break;
          }
        }
        if (match) {
          c++;
        }
      }
    }

    return c;
  }

  int hash(int[] arr, int s, int e) {
    int r = 0;
    for (int i = 0; i < arr.length; i++) {
      r += arr[i];
    }
    return r;
  }
}