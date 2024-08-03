/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 43.69 MB (beats 43.51 %)
 * tags: binary search tree, bst, in-order-traversal
 */

class Solution {
    Integer prev = null;
    boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return isValid;
    }

    void inOrder(TreeNode n) {
        if (n == null) return;
        inOrder(n.left);
        if (prev != null && n.val <= prev) {
            isValid = false;
            return;
        }
        prev = n.val;
        inOrder(n.right);
    }
}