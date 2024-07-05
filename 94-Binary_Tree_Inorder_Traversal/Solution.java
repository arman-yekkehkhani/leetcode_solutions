/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 41.37 MB (beats 70.14%)
 * tags: binary tree, in-order traversal, iterative
 */

class Solution {
    class Node {
        TreeNode n;
        boolean exp;
        Node(TreeNode n, boolean exp) {
            this.n = n; this.exp = exp;
        }
    }

    Node[] stack = new Node[100];
    int i = 0;
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        stack[i++] = new Node(root.right, false);
        stack[i++] = new Node(root, true);
        stack[i++] = new Node(root.left, false);
        while (i > 0 ) {
            i--;
            if (stack[i].n == null) {
                continue;
            }
            if (stack[i].exp) {
                res.add(stack[i].n.val);
            } else {
                var r = stack[i];
                stack[i++] = new Node(r.n.right, false);
                stack[i++] = new Node(r.n, true);
                stack[i++] = new Node(r.n.left, false);
            }
        }
        return res;
    }
}