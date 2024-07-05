/**
 * Author: Arman Yekkehkhani
 * Runtime: 1ms (beats 99.85%)
 * Memory: 45.86 MB (beats 11.59%)
 * tags: binary tree
 */

class Solution {
    class Stat{
        long sum;
        int n;
    }
    Stat[] st = new Stat[10_000];
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        acc(root, 0);
        for(Stat s : st) {
            if (s == null) {
                break;
            }
            res.add(((double) s.sum) / s.n);
        }
        return res;
    }

    void acc(TreeNode n, int l) {
        if (n == null) {
            return;
        }
        if (st[l] == null) {
            st[l] = new Stat();
        }
        st[l].sum += n.val;
        st[l].n++;
        acc(n.right, l + 1);
        acc(n.left, l + 1);
    }
}