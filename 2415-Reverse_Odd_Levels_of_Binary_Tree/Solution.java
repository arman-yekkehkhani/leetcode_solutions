/**
 * Author: Arman Yekkehkhani
 * Runtime: 15ms (beats 10.80%)
 * Memory: 47.65 MB (beats 9.94%)
 * tags: binary tree
 * Note: can be solved easier, solution 2
 */

class Solution {
    class Node {
        TreeNode n;
        int l;

        Node(TreeNode n, int l) {
            this.n = n;
            this.l = l;
        }
    }

    int[] arr = new int[16_384];
    int s = 0;

    public TreeNode reverseOddLevels(TreeNode root) {
        bfs(root);
        return tree(0);
    }

    TreeNode tree(int idx) {
        var r = new TreeNode(arr[idx]);
        if (2 * idx + 1 < s) {
            r.left = tree(2 * idx + 1);
            r.right = tree(2 * idx + 2);
        }
        return r;
    }

    void bfs(TreeNode root) {
        boolean toRight = true;
        Deque<Node> deq = new LinkedList<>();
        deq.addLast(new Node(root, 0));
        int currentL = 0;
        while (!deq.isEmpty()) {
            if ((toRight && deq.getFirst().l != currentL) || (!toRight && deq.getLast().l != currentL)) {
                currentL++;
                toRight = !toRight;
            }

            if (toRight) {
                var n = deq.removeFirst();
                arr[s++] = n.n.val;
                if (n.n.right != null) {
                    deq.addLast(new Node(n.n.left, n.l + 1));
                    deq.addLast(new Node(n.n.right, n.l + 1));
                }
            } else {
                var n = deq.removeLast();
                arr[s++] = n.n.val;
                if (n.n.right != null) {
                    deq.addFirst(new Node(n.n.right, n.l + 1));
                    deq.addFirst(new Node(n.n.left, n.l + 1));
                }
            }
        }
    }
}

// not my idea :)
class Solution2 {
    public TreeNode reverseOddLevels(TreeNode root) {
        reverseOdd(root.right, root.left, 1);
        return root;
    }

    void reverseOdd(TreeNode r1, TreeNode r2, int level) {
        if (r1 == null) {
            return;
        }

        if (level % 2 == 1) {
            var temp = r1.val;
            r1.val = r2.val;
            r2.val = temp;
        }

        reverseOdd(r1.left, r2.right, level + 1);
        reverseOdd(r1.right, r2.left, level + 1);
    }
}