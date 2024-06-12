/**
 * Author: Arman Yekkehkhani
 * Runtime: 14ms (beats 98.25%)
 * Memory: 57.77 MB (beats 75.91%)
 * tags: heap, hash
 */

class Solution {
    class Node {
        int i;
        int n;
    }

    int[] c = new int[100_000];

    public int minSetSize(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            c[arr[i] - 1]++;
        }

        Queue<Node> heap = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1.n, o2.n));
        for (int i = 0; i < 100_000; i++) {
            if (c[i] != 0) {
                Node n = new Node();
                n.i = i + 1;
                n.n = c[i];
                heap.offer(n);
            }
        }

        int res = 0;
        int s = 0;
        while (!heap.isEmpty()) {
            Node n = heap.poll();
            s += n.n;
            res++;
            if (s >= arr.length / 2) {
                break;
            }
        }

        return res;
    }
}