/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 44.38 MB (beats 85.80%)
 * tags: binary tree
 */

class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int r = depth(root.right);
        int l = depth(root.left);
        max = Math.max(max, r + l);

        return 1 + Math.max(r, l);
    }
}