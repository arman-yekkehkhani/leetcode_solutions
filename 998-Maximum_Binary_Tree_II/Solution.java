/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 41.57 MB (beats 33.70 %)
 * tags:
 */

class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val > root.val) {
            var tn = new TreeNode(val);
            tn.left = root;
            return tn;
        }

        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}