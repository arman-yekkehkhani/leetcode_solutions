/**
 * Author: Arman Yekkehkhani
 * tags: heap
 */

class Solution {
    class Node {
        int n;
        int idx;

        public Node(int n, int idx) {
            this.n = n;
            this.idx = idx;
        }
    }

    Node[] heap;

    public int[] maxSubsequence(int[] nums, int k) {
        heap = new Node[k];
        for (int i = 0; i < k; i++) {
            heap[i] = new Node(-100_001, 0);
        }

        for (int i = 0; i < nums.length; i++) {
            add(nums[i], i);
        }

        Arrays.sort(heap, Comparator.comparingInt(o -> o.idx));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap[i].n;
        }

        return res;
    }

    void add(int n, int idx) {
        if (n <= heap[0].n) {
            return;
        }

        pop();
        insert(n, idx);
    }

    void pop() {
        heap[0] = heap[heap.length - 1];
        down_heap(1);
    }

    void down_heap(int i) {
        if ((2 * i <= heap.length && get(2 * i).n < get(i).n)
                || (2 * i + 1 <= heap.length && get(2 * i + 1).n < get(i).n)) {
            int j = 2 * i + 1;
            if (2 * i + 1 > heap.length || get(2 * i).n < get(2 * i + 1).n) {
                j = 2 * i;
            }
            swap(i, j);
            down_heap(j);
        }
    }

    void insert(int n, int idx) {
        heap[heap.length - 1] = new Node(n, idx);
        int i = heap.length;
        int father = i / 2;
        while (father > 0 && get(i).n < get(father).n) {
            swap(father, i);
            i = father;
            father = i / 2;
        }
    }

    Node get(int i) {
        return heap[i - 1];
    }

    void swap(int i, int j) {
        Node temp = heap[i - 1];
        heap[i - 1] = get(j);
        heap[j - 1] = temp;
    }

}