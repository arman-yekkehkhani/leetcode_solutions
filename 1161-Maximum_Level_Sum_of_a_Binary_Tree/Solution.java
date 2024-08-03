/**
 * Author: Arman Yekkehkhani
 * Runtime: 2 ms (beats 100.00 %)
 * Memory: 46.73 MB (beats 84.43 %)
 * tags: binary tree, traversal
 */

class Solution {
    int[] lvlSum = new int[10_000];
    int maxD = 0;

    public int maxLevelSum(TreeNode root) {
        dfs(root, 0);
        int lvl = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < maxD + 1; i++) {
            if (lvlSum[i] > max) {
                lvl = i;
                max = lvlSum[i];
            }
        }
        return lvl + 1;
    }

    void dfs(TreeNode root, int l) {
        if (root == null) return;

        maxD = Math.max(l, maxD);
        lvlSum[l] += root.val;

        dfs(root.right, l + 1);
        dfs(root.left, l + 1);
    }
}

