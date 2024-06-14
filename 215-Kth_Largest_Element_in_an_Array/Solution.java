/**
 * Author: Arman Yekkehkhani
 * Runtime: 34ms (beats 74.56%)
 * Memory: 59.96 MB (beats 32.56%)
 * tags: heap
 */

class Solution {
    int[] heap;

    public int findKthLargest(int[] nums, int k) {
        heap = new int[k];
        Arrays.fill(heap, -10_001);

        for (int n : nums) {
            if (n > heap[0]) {
                pop();
                insert(n);
            }
        }

        return heap[0];
    }

    void pop() {
        heap[0] = heap[heap.length - 1];
        down_heap(1);
    }

    void down_heap(int i) {
        if ((2 * i <= heap.length && get(2 * i) < get(i))
                || (2 * i + 1 <= heap.length && get(2 * i + 1) < get(i))) {
            int j = 2 * i + 1;
            if (2 * i + 1 > heap.length || get(2 * i) < get(2 * i + 1)) {
                j = 2 * i;
            }
            swap(i, j);
            down_heap(j);
        }
    }

    void insert(int j) {
        heap[heap.length - 1] = j;
        int i = heap.length;
        while (i / 2 > 0 && get(i / 2) > get(i)) {
            swap(i, i / 2);
            i /= 2;
        }
    }

    int get(int i) {
        return heap[i - 1];
    }

    void swap(int i, int j) {
        int tmp = heap[i - 1];
        heap[i - 1] = heap[j - 1];
        heap[j - 1] = tmp;
    }
}