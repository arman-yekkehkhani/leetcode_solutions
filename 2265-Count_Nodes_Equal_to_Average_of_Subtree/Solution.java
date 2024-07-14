/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 54.74%)
 * Memory: 43.90 MB (beats 71.47%)
 * tags: binary tree
 */

class Solution {
    int c;

    public int averageOfSubtree(TreeNode root) {
        sum(root);
        return c;
    }

    Pair<Integer, Integer> sum(TreeNode r) {
        if (r == null) {
            return new Pair(0, 0);
        }

        var rsp = sum(r.right);
        var lsp = sum(r.left);

        int sum = rsp.getKey() + lsp.getKey() + r.val;
        int num = rsp.getValue() + lsp.getValue() + 1;
        int avg = sum / num;
        if (avg == r.val) {
            c++;
        }
        return new Pair(sum, num);
    }
}