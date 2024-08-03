/**
 * Author: Arman Yekkehkhani
 * Runtime: 1 ms (beats 21.73 %)
 * Memory: 42.36 MB (beats 15.22 %)
 * tags:
 */

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode curr = root;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(curr.left);
        dq.addLast(curr.right);

        while (!dq.isEmpty()) {
            TreeNode n = dq.removeFirst();
            if (n == null) continue;
            curr.right = n;
            curr.left = null;
            curr = n;
            dq.addFirst(n.right);
            dq.addFirst(n.left);
        }
    }
}