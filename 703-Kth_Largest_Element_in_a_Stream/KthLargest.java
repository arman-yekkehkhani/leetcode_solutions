/**
 * Author: Arman Yekkehkhani
 * tags: heap
 */

class KthLargest {
    int[] heap;

    public KthLargest(int k, int[] nums) {
        // min heap of k -> n
        // add k -> k log n
        // for any add remove min, log(n)
        heap = new int[k];
        Arrays.fill(heap, -1 * (10_000 + 1));

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (val <= heap[0]) {
            return heap[0];
        }

        pop();
        heap[heap.length - 1] = val;
        up_heap(heap.length);
        return heap[0];
    }

    void up_heap(int i) {
        int father = i / 2;

        if (father >= 1 && get(i) < get(father)) {
            swap(father, i);
            up_heap(father);
        }
    }

    void pop() {
        heap[0] = get(heap.length);
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

    int get(int i) {
        return heap[i - 1];
    }

    void swap(int i, int j) {
        int temp = get(i);
        heap[i - 1] = get(j);
        heap[j - 1] = temp;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */