/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 15.14%)
 * Memory: 40.94 MB (beats 23.03%)
 * tags: binary tree
 */

class Solution {
    Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (pq.size() == 2) {
            return pq.poll();
        }
        return -1;
    }

    void dfs(TreeNode r) {
        if (r == null) {
            return;
        }

        if (pq.isEmpty() || !pq.contains(r.val)) {
            pq.offer(r.val);
        }
        if (pq.size() > 2) {
            pq.poll();
        }
        dfs(r.right);
        dfs(r.left);
    }
}