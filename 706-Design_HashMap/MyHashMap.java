/**
 * Author: Arman Yekkehkhani
 * Runtime: 16ms (beats 85.12%)
 * Memory: 48.06 MB (beats 73.97%)
 * tags: hash
 */

class MyHashMap {
    class Kivy {
        int k, v;
    }

    int p = 10_007;
    List<Kivy>[] a = new List[p];

    public MyHashMap() {

    }

    public void put(int k, int v) {
        if (a[k % p] == null) {
            a[k % p] = new ArrayList<>();
            Kivy kv = new Kivy();
            kv.k = k;
            kv.v = v;
            a[k % p].add(kv);
        } else {
            for (Kivy kv : a[k % p]) {
                if (kv.k == k) {
                    kv.v = v;
                    return;
                }
            }
            Kivy kv = new Kivy();
            kv.k = k;
            kv.v = v;
            a[k % p].add(kv);
        }
    }

    public int get(int k) {
        if (a[k % p] == null) {
            return -1;
        }

        for (Kivy kv : a[k % p]) {
            if (kv.k == k) {
                return kv.v;
            }
        }

        return -1;
    }

    public void remove(int k) {
        if (a[k % p] == null) {
            return;
        }

        Kivy rm = null;
        for (Kivy kv : a[k % p]) {
            if (kv.k == k) {
                rm = kv;
                break;
            }
        }

        if (rm != null) {
            a[k % p].remove(rm);
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */