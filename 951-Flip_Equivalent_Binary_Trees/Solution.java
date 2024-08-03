/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 41.51 MB (beats 18.41 %)
 * tags: binary tree, recurssion
 */

class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        boolean case1 = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean case2 = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        return case1 || case2;
    }
}
