/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 51.36 MB (beats 18.5%)
 * tags: binary search tree, bst
 */

class Solution {
    int s = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val <= high && root.val >= low) {
            s += root.val;
        }

        if (root.val < high) {
            rangeSumBST(root.right, low, high);
        }

        if (root.val > low) {
            rangeSumBST(root.left, low, high);
        }

        return s;
    }
}