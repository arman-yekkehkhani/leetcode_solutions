/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 100%)
 * Memory: 44.24 MB (beats 44.54%)
 * tags: binary tree
 */

class Solution {
    boolean isb = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return isb;
    }

    int height(TreeNode n) {
        if (n == null) {
            return 0;
        }

        int l = height(n.left);
        int r = height(n.right);
        if (Math.abs(l - r) > 1) {
            isb = false;
        }
        return 1 + Math.max(l, r);
    }

}