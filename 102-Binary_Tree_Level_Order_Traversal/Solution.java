/**
 * Author: Arman Yekkehkhani
 * Runtime: 1 ms (beats 90.52 %)
 * Memory: 44.40 MB (beats 98.21 %)
 * tags: binary tree, breadth-first-search, bfs
 */


class Solution {
    TreeNode[] nodes = new TreeNode[2001];
    int[] lvl = new int[2001];
    int cap = 0;
    int idx = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        nodes[idx] = root;
        lvl[idx] = 0;
        cap++;

        while (idx <= cap) {
            if (lvl[idx] >= res.size()) {
                res.add(new ArrayList<>());
            }

            if (nodes[idx] == null) {
                idx++;
                continue;
            }

            res.get(lvl[idx]).add(nodes[idx].val);

            if (nodes[idx].left != null) {
                nodes[cap] = nodes[idx].left;
                lvl[cap] = lvl[idx] + 1;
                cap++;
            }
            if (nodes[idx].right != null) {
                nodes[cap] = nodes[idx].right;
                lvl[cap] = lvl[idx] + 1;
                cap++;
            }
            idx++;
        }

        return res;
    }
}
