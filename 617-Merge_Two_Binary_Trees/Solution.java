/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 44.75 MB (beats 51.93%)
 * tags: binary tree
 */

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        var n = new TreeNode();
        if (root1 == null) {
            n.val += root2.val;
            n.right = root2.right;
            n.left = root2.left;
        } else if (root2 == null) {
            n.val += root1.val;
            n.right = root1.right;
            n.left = root1.left;
        } else {
            n.val = root1.val + root2.val;
            n.right = mergeTrees(root1.right, root2.right);
            n.left = mergeTrees(root1.left, root2.left);
        }
        return n;
    }
}