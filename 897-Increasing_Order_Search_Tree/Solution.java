/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100%)
 * Memory: 41.20 MB (beats 34.34%)
 * tags: binary search tree, in-order traversal
 */

class Solution {
    TreeNode dx;

    public TreeNode increasingBST(TreeNode root) {
        dx = new TreeNode();
        var r = dx;
        trav(root);
        return r.right;
    }

    void trav(TreeNode n) {
        if (n.left == null && n.right == null) {
            dx.right = new TreeNode(n.val);
            dx = dx.right;
            return;
        }
        if (n.left != null) {
            trav(n.left);
        }
        dx.right = new TreeNode(n.val);
        dx = dx.right;
        if (n.right != null) {
            trav(n.right);
        }
    }
}