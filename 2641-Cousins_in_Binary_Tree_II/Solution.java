/**
 * Author: Arman Yekkehkhani
 * Runtime: 14 ms (beats 97.05 %)
 * Memory: 79.79 MB (beats 35.06 %)
 * tags: binary tree, breadth-first-search, bfs, array
 */

class Solution {
    int[] lvlSum = new int[100_000];

    public TreeNode replaceValueInTree(TreeNode root) {
        SumPerLevel(root, 0);
        replaceVal(root, root.val, 0);
        return root;
    }

    void SumPerLevel(TreeNode node, int l) {
        if (node == null) return;
        lvlSum[l] += node.val;
        SumPerLevel(node.right, l + 1);
        SumPerLevel(node.left, l + 1);
    }

    void replaceVal(TreeNode tn, int sum, int l) {
        if (tn == null) return;

        tn.val = lvlSum[l] - sum;

        int s = 0;
        if (tn.left != null) {
            s += tn.left.val;
        }

        if (tn.right != null) {
            s += tn.right.val;
        }

        replaceVal(tn.left, s, l + 1);
        replaceVal(tn.right, s, l + 1);
    }
}