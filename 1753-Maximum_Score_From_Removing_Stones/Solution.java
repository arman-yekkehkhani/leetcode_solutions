/**
 * Author: Arman Yekkehkhani
 * Runtime: 70ms (beats 48.53%)
 * Memory: 44.3 MB (beats 32.57%)
 * tags: heap
 */

class Solution {
    public int maximumScore(int a, int b, int c) {
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        heap.offer(a);
        heap.offer(b);
        heap.offer(c);

        int s = 0;
        while(true) {
            int max = heap.poll();
            int mid = heap.poll();

            if (max == 0 || mid == 0) {
                break;
            }
            s++;
            heap.offer(max - 1);
            heap.offer(mid - 1);
        }
        return s;
    }
}