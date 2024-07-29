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

/**
 * Author: Arman Yekkehkhani
 * Runtime: 5 ms (beats 99.79 %)
 * Memory: 68.45 MB (beats 96.80 %)
 * tags: binary tree, depth-first-search, dfs, bit manipulation
 */

class Solution {
    int num = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int parity = 0;
        dfs(root, parity);
        return num;
    }

    void dfs(TreeNode root, int parity) {
        if (root == null) return;

        parity ^= (1 << root.val);

        if (root.right == null && root.left == null) {
            if ((parity & (parity - 1)) == 0) {
                num++;
            }
            return;
        }

        dfs(root.left, parity);
        dfs(root.right, parity);
    }
}