/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100%)
 * Memory: 41.61 MB (beats 5.88%)
 * tags: binary search tree, in-order traversal
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        var tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}