/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 41.47 MB (beats 91.15%)
 * tags: heap
 */

class Solution {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        sum(root, 0);
        return sum;
    }

    void sum(TreeNode n, int s) {
        if (n == null) {
            return;
        }

        s = (s << 1) + n.val;
        if (n.left == null && n.right == null) {
            sum += s;
        }

        sum(n.right, s);
        sum(n.left, s);
    }
}