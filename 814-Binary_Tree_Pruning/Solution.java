/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 41.02 MB (beats 50.73 %)
 * tags: binary tree
 */

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (noOne(root)) {
            return null;
        }
        return root;
    }

    boolean noOne(TreeNode n) {
        if (n == null) {
            return true;
        }

        var l = noOne(n.left);
        if (l) {
            n.left = null;
        }

        var r = noOne(n.right);
        if (r) {
            n.right = null;
        }

        return r && l && n.val == 0;
    }
}