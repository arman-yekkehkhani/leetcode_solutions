/**
 * Author: Arman Yekkehkhani
 * Runtime: 5ms (beats 56.45%)
 * Memory: 64.48 MB (beats 18.77%)
 * tags: binary tree
 */

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        var l = minDepth(root.left);
        var r =  minDepth(root.right);
        if (l == 0) {
            return 1 + r;
        } else if (r == 0) {
            return 1 + l;
        } else {
            return 1 + Math.min(l, r);
        }
    }
}