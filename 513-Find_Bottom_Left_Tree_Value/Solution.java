/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 44.65 MB (beats 33.84 %)
 * tags: binary tree
 */

class Solution {
    int val = 0;
    int maxd = -1;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return val;
    }

    void dfs(TreeNode root, int d) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            if (d > maxd) {
                val = root.val;
                maxd = d;
            }
        }

        dfs(root.left, d + 1);
        dfs(root.right, d + 1);
    }
}
