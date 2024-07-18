/**
 * Author: Arman Yekkehkhani
 * Runtime: 2ms (beats 86.08%)
 * Memory: 51.98 MB (beats 78.46%)
 * tags: binary tree, depth-first-search, dfs
 */

class Solution {
    int n = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return n;
    }

    void dfs(TreeNode r, int max) {
        if (r == null) {
            return;
        }

        if (r.val >= max) {
            n++;
            max = r.val;
        }

        dfs(r.left, max);
        dfs(r.right, max);
    }
}