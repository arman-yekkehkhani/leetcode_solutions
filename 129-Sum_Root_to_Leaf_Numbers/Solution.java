/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 40.84 MB (beats 77.66 %)
 * tags: binary tree, depth-first-search, dfs
 */

class Solution {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return total;
    }

    void dfs(TreeNode root, int sum) {
        if (root == null) return;

        if (root.right == null && root.left == null) {
            total += 10 * sum + root.val;
        }

        dfs(root.left, 10 * sum + root.val);
        dfs(root.right, 10 * sum + root.val);
    }
}