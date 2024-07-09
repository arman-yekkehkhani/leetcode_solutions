/**
 * Author: Arman Yekkehkhani
 * Runtime: 10ms (beats 18%)
 * Memory: 42.55 MB (beats 39.24%)
 * tags: binary tree
 */

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.right == null && root.left == null) {
            return List.of("" + root.val);
        }
        List<String> res = new ArrayList<>();
        var r = binaryTreePaths(root.right);
        var l = binaryTreePaths(root.left);
        for (String s : r) {
            res.add(root.val + "->" + s);
        }
        for (String s : l) {
            res.add(root.val + "->" + s);
        }
        return res;
    }
}