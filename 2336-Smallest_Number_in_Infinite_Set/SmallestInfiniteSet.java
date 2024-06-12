/**
 * Author: Arman Yekkehkhani
 * Runtime: 8ms (beats 100%)
 * Memory: 45 MB (beats 75.98%)
 */

class SmallestInfiniteSet {
    int[] heap =  new int[1000];
    boolean[] visited = new boolean[1000];
    int h_size = 0;
    int last = 1;

    public SmallestInfiniteSet() {}

    public int popSmallest() {
        if (h_size > 0) {
            int res =  heap_pop();
            return res;
        }
        return last++;
    }

    int heap_pop() {
        int s = heap[0];
        heap[0] = heap[h_size - 1];
        h_size--;
        down_heap(1);
        visited[s - 1] = false;
        return s;
    }

    void down_heap(int i) {
        if ((2 * i <= h_size && get(2 * i) < get(i)) ||
                (2 * i + 1 <= h_size && get(2 * i + 1) < get(i))) {
            int j = 2 * i + 1;
            if (2 * i + 1 > h_size || get(2 * i) < get(2 * i + 1)) {
                j = 2 * i;
            }
            swap(i, j);
            down_heap(j);
        }
    }

    public void addBack(int num) {
        if (num >= last) {
            return;
        }

        if (visited[num - 1]) {
            return;
        }
        visited[num - 1] = true;

        heap[h_size] = num;
        up_heap(h_size + 1);
        h_size++;
    }

    void up_heap (int i) {
        int father = i / 2;
        if (father > 0 && get(i) < get(father)) {
            swap(i, father);
            up_heap(father);
        }
    }

    int get(int i) {
        return heap[i - 1];
    }

    void swap(int i, int j) {
        int temp = heap[i - 1];
        heap[i - 1] = heap[j - 1];
        heap[j - 1] = temp;
    }
}
