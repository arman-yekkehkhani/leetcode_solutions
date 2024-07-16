/**
 * Author: Arman Yekkehkhani
 * Runtime: 19ms (beats 95.86%)
 * Memory: 55.86 MB (beats 52.87%)
 * tags: binary tree
 */

class Solution {
    int[] st = new int[100_001];
    int[][] ch = new int[2][100_001];

    public TreeNode createBinaryTree(int[][] descriptions) {
        for (int[] d : descriptions) {
            ch[d[2]][d[0]] = d[1];
            if (st[d[0]] == 0) {
                st[d[0]] = 1;
            }
            st[d[1]] = 2;
        }

        var root = new TreeNode();
        for (int i = 0; i < st.length; i++) {
            if (st[i] == 1) {
                root.val = i;
            }
        }
        build(root);
        return root;
    }

    void build(TreeNode r) {
        if (ch[0][r.val] != 0) {
            r.right = new TreeNode(ch[0][r.val]);
            build(r.right);
        }
        if (ch[1][r.val] != 0) {
            r.left = new TreeNode(ch[1][r.val]);
            build(r.left);
        }
    }
}