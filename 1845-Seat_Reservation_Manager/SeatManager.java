/**
 * Author: Arman Yekkehkhani
 * Runtime: 32ms (beats 98.77%)
 * Memory: 69.4 MB (beats 85.42%)
 */

class SeatManager {
    Queue<Integer> heap;
    int last = 1;

    public SeatManager(int n) {
        heap = new PriorityQueue(n);
    }

    public int reserve() {
        if (heap.isEmpty()) {
            return last++;
        }
        return heap.poll();
    }

    public void unreserve(int seatNumber) {
        heap.offer(seatNumber);
    }
}
