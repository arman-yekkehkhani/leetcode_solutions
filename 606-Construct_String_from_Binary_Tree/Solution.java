/**
 * Author: Arman Yekkehkhani
 * Runtime: 1 ms (beats 100.00 %)
 * Memory: 44.18 MB (beats 75.33 %)
 * tags:
 */

class Solution {
    StringBuilder sb = new StringBuilder();

    public String tree2str(TreeNode root) {
        preorder(root);
        return sb.toString();
    }

    void preorder(TreeNode n) {
        if (n == null) return;

        sb.append(n.val);

        if (n.left == null && n.right == null) return;

        sb.append("(");
        preorder(n.left);
        sb.append(")");

        if (n.right == null) return;
        sb.append("(");
        preorder(n.right);
        sb.append(")");
    }
}