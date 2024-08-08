/**
 * Author: Arman Yekkehkhani
 * Runtime: 1 ms (beats 64.99 %)
 * Memory: 40.95 MB (beats 60.65 %)
 * tags: pascal tree
 */

// Time Complx: O(n^2)
// Space Complx: O(n^2)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }

        List<Integer> prevRow = getRow(rowIndex - 1);
        List<Integer> row = new ArrayList<>(prevRow.size() + 1);
        row.addFirst(1);
        for (int i = 0; i < prevRow.size() - 1; i++) {
            row.add(prevRow.get(i) + prevRow.get(i + 1));
        }
        row.addLast(1);
        return row;
    }
}

// Time Complx: O(n^2)
// Space Complx: O(n)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new LinkedList<>();
        row.add(1);
        if (rowIndex == 0) return row;
        row.add(1);
        if (rowIndex == 1) return row;

        while (--rowIndex > 0) {
            ListIterator<Integer> lit = row.listIterator();
            while (true) {
                if (lit.nextIndex() >= row.size() - 1) break;
                Integer s = lit.next() + lit.next();
                lit.previous();
                lit.previous();
                lit.remove();
                lit.add(s);
            }
            row.addFirst(1);
        }

        return row;
    }
}