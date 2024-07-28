/**
 * Author: Arman Yekkehkhani
 * Runtime: 15 ms (beats 51.89 %)
 * Memory: 69.41 MB (beats 80.42 %)
 * tags: binary tree, depth-first-search, dfs, hash
 */

class Solution {
    int[] count = new int[10];
    int num = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        dfs(root);
        return num;
    }

    void dfs(TreeNode root) {
        if (root == null) return;

        count[root.val]++;
        if (root.right == null && root.left == null) {
            int odds = 0;
            for (int i : count) {
                if (i % 2 == 1) {
                    odds++;
                }
            }

            if (odds <= 1) {
                num++;
            }
        }

        dfs(root.left);
        dfs(root.right);
        count[root.val]--;
    }
}