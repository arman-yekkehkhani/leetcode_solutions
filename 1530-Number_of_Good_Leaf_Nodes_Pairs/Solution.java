/**
 * Author: Arman Yekkehkhani
 * Runtime: 11 ms (beats 46.55 %)
 * Memory: 44.84 MB (beats 50.64 %)
 * tags:
 */

class Solution {
    int pairs = 0;
    int d = 0;

    public int countPairs(TreeNode root, int distance) {
        d = distance;
        distToLeaves(root);
        return pairs;
    }

    List<Integer> distToLeaves(TreeNode node) {
        if (node == null) {
            return Collections.emptyList();
        }

        if (node.left == null && node.right == null) {
            return List.of(1);
        }

        var l = distToLeaves(node.left);
        var r = distToLeaves(node.right);
        pairs += goodPairs(r, l);
        var res = merge(r, l);
        return res;
    }

    int goodPairs(List<Integer> r, List<Integer> l) {
        int c = 0;
        for (int ri : r) {
            for (int li : l) {
                if (ri + li <= d) {
                    c++;
                }
            }
        }
        return c;
    }

    List<Integer> merge(List<Integer> r, List<Integer> l) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int len = r.size() + l.size();
        while (i + j < len) {
            int val;
            if (i >= r.size()) {
                val = l.get(j++) + 1;
            } else if (j >= l.size()) {
                val = r.get(i++) + 1;
            } else if (r.get(i) < l.get(j)) {
                val = r.get(i++) + 1;
            } else {
                val = l.get(j++) + 1;
            }

            if (val < d) {
                res.add(val);
            }
        }
        return res;
    }
}