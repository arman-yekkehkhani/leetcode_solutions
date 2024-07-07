/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 41.56 MB (beats 31.56%)
 * tags: binary tree, pre-order traversal
 */

class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        trav(root);
        return res;
    }

    void trav(TreeNode n) {
        if (n == null) {
            return;
        }
        res.add(n.val);
        trav(n.left);
        trav(n.right);
    }
}