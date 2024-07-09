/**
 * Author: Arman Yekkehkhani
 * Runtime: 7ms (beats 26.34%)
 * Memory: 45.16 MB (beats 38.26%)
 * tags: binary tree
 */

class Solution {
    Map<Integer, Integer> m = new HashMap<>();
    public int[] findMode(TreeNode root) {
        trav(root);
        int c = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> kv : m.entrySet()) {
            if (kv.getValue() > max) {
                max = kv.getValue();
                c = 1;
            } else if (kv.getValue() == max) {
                c++;
            }
        }

        int[] res = new int[c];
        for (Map.Entry<Integer, Integer> kv : m.entrySet()) {
            if (kv.getValue() == max) {
                res[--c] = kv.getKey();
            }
        }
        return res;
    }

    void trav(TreeNode r) {
        if (r == null) {
            return;
        }
        m.put(r.val, m.getOrDefault(r.val, 0) + 1);
        trav(r.left);
        trav(r.right);
    }
}
