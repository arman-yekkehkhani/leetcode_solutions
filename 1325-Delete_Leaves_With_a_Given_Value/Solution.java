/**
 * Author: Arman Yekkehkhani
 * Runtime: 15ms (beats 10.80%)
 * Memory: 47.65 MB (beats 9.94%)
 * tags: binary tree, depth-first-search, dfs
 */

class Solution {
    int t;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        t = target;
        if (dfs(root)) {
            return null;
        }
        return root;
    }

    boolean dfs(TreeNode r) {
        if (r == null) {
            return false;
        }

        if (r.right == null && r.left == null) {
            return r.val == t;
        }

        if (dfs(r.right)) {
            r.right = null;
        }
        if (dfs(r.left)) {
            r.left = null;
        }

        if (r.right == null && r.left == null) {
            return r.val == t;
        }
        return false;
    }
}