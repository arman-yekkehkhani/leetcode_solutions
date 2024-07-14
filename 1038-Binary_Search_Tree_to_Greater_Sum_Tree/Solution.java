/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 40.94 MB (beats 48.11%)
 * tags: binary tree, in-order traversal
 */

class Solution {
    int s = 0;
    public TreeNode bstToGst(TreeNode root) {
        reverseInOrder(root);
        return root;
    }

    void reverseInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        reverseInOrder(root.right);
        root.val += s;
        s = root.val;
        reverseInOrder(root.left);
    }
}