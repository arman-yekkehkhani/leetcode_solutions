/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 41.46 MB (beats 72.36%)
 * tags: binary tree
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }

        if (l == null || r == null || r.val != l.val) {
            return false;
        }

        return isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }
}