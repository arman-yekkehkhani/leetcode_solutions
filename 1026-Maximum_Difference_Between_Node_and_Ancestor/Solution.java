/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 41.86 MB (beats 47.90%)
 * tags: binary tree
 */

class Solution {
    int maxol = 0;

    public int maxAncestorDiff(TreeNode root) {
        minMax(root);
        return maxol;
    }

    int[] minMax(TreeNode r) {
        if (r == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        var mmr = minMax(r.right);
        var mml = minMax(r.left);
        var min = Math.min(mmr[0], mml[0]);
        var max = Math.max(mmr[1], mml[1]);

        if (min < Integer.MAX_VALUE) {
            maxol = Math.max(Math.abs(r.val - min), maxol);
        }
        if (max > Integer.MIN_VALUE) {
            maxol = Math.max(Math.abs(r.val - max), maxol);
        }

        return new int[]{Math.min(r.val, min), Math.max(r.val, max)};
    }
}