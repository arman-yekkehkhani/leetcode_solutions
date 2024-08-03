/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 44.34 MB (beats 25.99 %)
 * tags: binary tree
 */

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;

        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}