/**
 * Author: Arman Yekkehkhani
 * Runtime: 0ms (beats 100%)
 * Memory: 41.23 MB (beats 54.51%)
 * tags: binary tree
 */

class Solution {
    List<Integer> r1 = new ArrayList<>();
    List<Integer> r2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        trav(root1, r1);
        trav(root2, r2);

        if (r1.size() != r2.size()) {
            return false;
        }
        for (int i = 0 ; i < r1.size(); i++) {
            if (!r1.get(i).equals(r2.get(i))) {
                return false;
            }
        }
        return true;
    }

    void trav(TreeNode n, List<Integer> r) {
        if (n == null) {
            return;
        }

        if (n.right == null && n.left == null) {
            r.add(n.val);
            return;
        }
        trav(n.right, r);
        trav(n.left, r);
    }
}