/**
 * Author: Arman Yekkehkhani
 * Runtime: 5 ms (beats 63.42 %)
 * Memory: 45.56 MB (beats 18.69 %)
 * tags: binary tree, hash table
 */

class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        int maxFreq = 0;
        int c = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                c = 1;
                maxFreq = entry.getValue();
            } else if (entry.getValue() == maxFreq) {
                c++;
            }
        }

        int[] res = new int[c];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxFreq) {
                res[--c] = entry.getKey();
            }
        }
        return res;
    }

    int sum(TreeNode root) {
        if (root == null) return 0;
        int s = root.val + sum(root.left) + sum(root.right);
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}