/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 99.57%)
 * Memory: 44.05 MB (beats 72.96%)
 * tags: tree
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean isub = false;
    TreeNode s;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        s = subRoot;

        dfs(root);
        return isub;
    }

    void dfs(TreeNode r) {
        if (isub || is_eq(r, s)) {
            isub = true;
            return;
        }

        if (r.right != null) {
            dfs(r.right);
        }
        if (r.left != null) {
            dfs(r.left);
        }
    }

    boolean is_eq(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val == b.val && is_eq(a.right, b.right) && is_eq(a.left, b.left)) {
            return true;
        }
        return false;
    }
}