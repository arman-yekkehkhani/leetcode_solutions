/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 42.06 MB (beats 5.18%)
 * tags: binary search tree
 */

class Solution {
    class Node {
        TreeNode n;
        boolean exp;
        Node (TreeNode n, boolean e) {
            this.n = n;
            this.exp = e;
        }
    }

    Node[] st = new Node[100];
    int i = 0;
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        st[i++] = new Node(root, true);
        st[i++] =  new Node(root.right, false);
        st[i++] =  new Node(root.left, false);

        while(i > 0) {
            i--;
            if (st[i].n == null) {
                continue;
            }

            if (st[i].exp) {
                res.add(st[i].n.val);
            } else {
                var t = st[i].n;
                st[i++] = new Node(t, true);
                st[i++] = new Node(t.right, false);
                st[i++] = new Node(t.left, false);
            }
        }

        return res;
    }
}