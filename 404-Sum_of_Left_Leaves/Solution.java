/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 41.08 MB (beats 82.09%)
 * tags: binary tree
 */

class Solution {
    int s = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        trav(root, false);
        return s;
    }

    void trav(TreeNode r, boolean isLeft) {
        if (r.right == null && r.left == null && isLeft) {
            s += r.val;
        }
        if (r.right != null) {
            trav(r.right, false);
        }
        if (r.left != null) {
            trav(r.left, true);
        }
    }
}