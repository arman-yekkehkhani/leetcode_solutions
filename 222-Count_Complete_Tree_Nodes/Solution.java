/**
 * Author: Arman Yekkehkhani
 * Runtime: 6ms (beats 5.01%)
 * Memory: 47.45 MB (beats 52.12%)
 * tags: binary tree
 */

class Solution {
    int h = 0;
    int c = 0;
    boolean stop;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        count(root);
        trav(root, 1);

        System.out.println(h + " " + c);
        return (int) Math.pow(2, h - 1) + c - 1;
    }

    void trav(TreeNode n, int l) {
        if (stop || n == null) {
            return;
        }

        if (n.right == null && n.left == null && l == h) {
            c++;
            return;
        }
        trav(n.left, l + 1);
        trav(n.right, l + 1);
    }

    void count(TreeNode n) {
        if (n == null) {
            return;
        }
        h++;
        count(n.left);
    }
}