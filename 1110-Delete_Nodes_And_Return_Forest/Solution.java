/**
 * Author: Arman Yekkehkhani
 * Runtime: 0 ms (beats 100.00 %)
 * Memory: 44.57 MB (beats 80.73 %)
 * tags: binary tree
 */

class Solution {
    boolean[] del = new boolean[1001];
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int d : to_delete) {
            del[d] = true;
        }
        dfs(root, null, false);
        return res;
    }

    void dfs(TreeNode node, TreeNode parent, boolean isLeft) {
        if (node == null) return;

        if (del[node.val]) {
            if (parent != null) {
                if (isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            parent = null;
        } else {
            if (parent == null) {
                res.add(node);
            }
            parent = node;
        }
        dfs(node.right, parent, false);
        dfs(node.left, parent, true);
    }
}