/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 100%)
 * Memory: 46.50 MB (beats 26.85%)
 * tags: binary tree, dfs, depth-first-search
 */

class Solution {
    int maxl = 0;
    int s = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 1);
        return s;
    }

    void dfs(TreeNode r, int l) {
        if (r == null) {
            return;
        }

        if (l > maxl) {
            maxl = l;
            s = r.val;
        } else if (l == maxl) {
            s += r.val;
        }

        dfs(r.right, l + 1);
        dfs(r.left, l + 1);
    }


}