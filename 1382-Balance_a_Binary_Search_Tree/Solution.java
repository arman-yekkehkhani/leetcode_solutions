/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 100%)
 * Memory: 47.21 MB (beats 5.65%)
 * tags: binary tree
 */

class Solution {
    int[] nodes = new int[10_000];
    int idx = 0;
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return tree(nodes, 0, idx - 1);
    }

    TreeNode tree(int[] nodes, int s, int f) {
        int m = (s + f) / 2;
        var r = new TreeNode(nodes[m]);
        if (m < f) {
            r.left = tree(nodes, m + 1, f);
        }
        if (m > s) {
            r.right = tree(nodes, s, m - 1);
        }
        return r;
    }

    void inOrder(TreeNode r) {
        if (r == null) {
            return;
        }
        inOrder(r.right);
        nodes[idx++] = r.val;
        inOrder(r.left);
    }
}