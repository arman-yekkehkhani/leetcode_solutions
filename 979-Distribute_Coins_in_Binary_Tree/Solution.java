/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 42.38 MB (beats 7.87%)
 * tags: binary tree, depth-first-search, dfs
 */

class Solution {
    int s = 0;

    public int distributeCoins(TreeNode root) {
        dist(root);
        return s;
    }

    int dist(TreeNode r) {
        if (r == null) {
            return 0;
        }
        int ri = dist(r.right);
        int le = dist(r.left);
        s += (Math.abs(ri) + Math.abs(le));
        return r.val + ri + le - 1;
    }
}