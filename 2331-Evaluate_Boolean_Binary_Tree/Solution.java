/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 44.45 MB (beats 13.60%)
 * tags: binary tree
 */

class Solution {
    public boolean evaluateTree(TreeNode root) {
        switch(root.val) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return evaluateTree(root.left) || evaluateTree(root.right);
            case 3:
                return evaluateTree(root.left) && evaluateTree(root.right);
        }
        return false;
    }
}