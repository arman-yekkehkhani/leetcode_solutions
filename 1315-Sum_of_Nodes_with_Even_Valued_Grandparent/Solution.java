/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 100%)
 * Memory: 46.48 MB (beats 10.16%)
 * tags: binary tree
 */


class Solution {
    int s = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return s;
    }

    void dfs(TreeNode r, TreeNode p, TreeNode gp) {
        if (r == null) {
            return;
        }

        if (gp != null && gp.val % 2 == 0) {
            s += r.val;
        }

        dfs(r.right, r, p);
        dfs(r.left, r, p);
    }
}