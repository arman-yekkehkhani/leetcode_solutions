/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 44.04 MB (beats 64.32%)
 * tags: binary tree
 */

class Solution {
    int tt = 0;
    public int findTilt(TreeNode root) {
        sum(root);
        return tt;
    }

    int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var l = sum(root.left);
        var r = sum(root.right);
        tt += Math.abs(l - r);
        return l + r + root.val;
    }
}