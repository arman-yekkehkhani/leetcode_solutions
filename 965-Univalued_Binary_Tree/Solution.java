/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 41.27 MB (beats 18.49%)
 * tags: binary tree
 */

class Solution {
    boolean[] h = new boolean[100];
    public boolean isUnivalTree(TreeNode root) {
        trav(root);
        int c = 0;
        for (boolean i : h) {
            if (i) {
                c++;
            }
        }
        return c == 1;
    }

    void trav(TreeNode r) {
        if (r == null) {
            return;
        }

        h[r.val] = true;
        trav(r.right);
        trav(r.left);
    }
}