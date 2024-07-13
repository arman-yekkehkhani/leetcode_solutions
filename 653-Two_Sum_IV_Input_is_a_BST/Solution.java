/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 100%)
 * Memory: 44.88 MB (beats 69.69%)
 * tags: binary tree
 */

class Solution {
    TreeNode r;
    boolean found = false;

    public boolean findTarget(TreeNode root, int k) {
        r = root;
        dfs(root, k);
        return found;
    }

    void dfs(TreeNode root, int k) {
        if (found || root == null) {
            return;
        }

        int t = k - root.val;
        if (t != root.val && find(r, t)) {
            found = true;
            return;
        }
        dfs(root.right, k);
        dfs(root.left, k);
    }

    boolean find(TreeNode r, int t) {
        if (r.val == t) {
            return true;
        }

        if (t > r.val && r.right != null) {
            return find(r.right, t);
        }
        if (t < r.val && r.left != null) {
            return find(r.left, t);
        }
        return false;
    }
}