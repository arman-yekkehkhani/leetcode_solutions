/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 41.42 MB (beats 22.91%)
 * tags: binary tree
 */

class Solution {
    class Node {
        TreeNode parent;
        int depth;
    }

    Node xn = new Node();
    Node yn = new Node();
    int x;
    int y;
    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;

        if (root.val == x || root.val == y) {
            return false;
        }

        find(root, 0);

        if (xn.depth != yn.depth || (xn.depth == yn.depth && xn.parent == yn.parent)) {
            return false;
        }
        return true;
    }

    void find(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        boolean ret = false;
        if (checkChild(root.right, x) || checkChild(root.left, x)) {
            xn.parent = root;
            xn.depth = d + 1;
            ret = true;
        }
        if (checkChild(root.right, y) || checkChild(root.left, y)) {
            yn.parent = root;
            yn.depth = d + 1;
            ret = true;
        }
        if (ret) {
            return;
        }
        find(root.right, d + 1);
        find(root.left, d + 1);
    }

    boolean checkChild(TreeNode n, int v) {
        if (n == null) {
            return false;
        }
        if (n.val == v) {
            return true;
        }
        return false;
    }
}