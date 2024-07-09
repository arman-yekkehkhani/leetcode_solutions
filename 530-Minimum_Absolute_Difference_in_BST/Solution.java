/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 44.15 MB (beats 73.64%)
 * tags: binary tree
 */

class Solution {
    int diff = 100_001;
    public int getMinimumDifference(TreeNode root) {
        if (root.right != null) {
            var dr = Math.abs(root.val - leftMost(root.right));
            diff = Math.min(diff, dr);
            getMinimumDifference(root.right);
        }
        if (root.left != null) {
            var dl = Math.abs(root.val - rightMost(root.left));
            diff = Math.min(diff, dl);
            getMinimumDifference(root.left);
        }
        return diff;
    }

    int leftMost(TreeNode r) {
        var n = r;
        while (true) {
            if (n.left == null) {
                return n.val;
            }
            n = n.left;
        }
    }

    int rightMost(TreeNode r) {
        var n = r;
        while (true) {
            if (n.right == null) {
                return n.val;
            }
            n = n.right;
        }
    }
}