/**
 * Author: Arman Yekkehkhani
 * Runtime: 13ms (beats 81.71%)
 * Memory: 48.69 MB (beats 93.26%)
 * tags: hash
 */

class MyHashSet {
    int p = 10007;
    List<Integer>[] arr = new List[p];

    public MyHashSet() {

    }

    public void add(int key) {
        if (arr[key % p] == null) {
            arr[key % p] = new ArrayList<>();
            arr[key % p].add(key);
        } else {
            if (!arr[key % p].contains(key)) {
                arr[key % p].add(key);
            }
        }
    }

    public void remove(int key) {
        if (arr[key % p] != null) {
            arr[key % p].remove(Integer.valueOf(key));
        }
    }

    public boolean contains(int key) {
        if (arr[key % p] == null || !arr[key % p].contains(key)) {
            return false;
        }

        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */