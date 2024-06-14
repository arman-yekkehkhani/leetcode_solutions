/**
 * Author: Arman Yekkehkhani
 * Runtime: 2ms (beats 54.33%)
 * Memory: 41.1 MB (beats 54.81%)
 * tags: heap
 */

class Solution {
    public int fillCups(int[] amount) {
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        for (int i : amount) {
            heap.offer(i);
        }

        int s = 0;
        while (true) {
            int max = heap.poll();
            int mid = heap.poll();

            if (max == 0 || mid == 0) {
                s += max;
                break;
            }

            heap.offer(max - 1);
            heap.offer(mid - 1);
            s++;
        }

        return s;
    }
}