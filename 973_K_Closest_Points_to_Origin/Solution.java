/**
 * Author: Arman Yekkehkhani
 * Runtime: 34ms (beats 37.42%)
 * Memory: 48.21 MB (beats 91.24%)
 * tags: heap
 */

class Solution {
    class P {
        int[] co;
        double dist;
    }
    public int[][] kClosest(int[][] points, int k) {
        Queue<P> heap = new PriorityQueue<>((o1, o2) -> -Double.compare(o1.dist, o2.dist));
        for (int[] p : points) {
            P pp = new P();
            pp.co = p;
            pp.dist = p[1] * p[1] + p[0] * p[0];
            heap.offer(pp);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().co;
        }
        return res;
    }

}