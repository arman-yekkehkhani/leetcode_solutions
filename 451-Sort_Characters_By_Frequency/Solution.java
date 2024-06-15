/**
 * Author: Arman Yekkehkhani
 * Runtime: 261ms (beats 5.03%)
 * Memory: 48.86 MB (beats 32.56%)
 * tags: hash, sort
 */

class Solution {
    class ch {
        int n;
        char ch;
    }

    public String frequencySort(String s) {
        ch[] cs = new ch[62];
        // 0-9 48 - 57
        // A-Z 65 - 90
        // a-z 97 - 122
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new ch();
            if (i < 10) {
                cs[i].ch = (char) (i + 48);
            } else if (i < 36) {
                cs[i].ch = (char) (55 + i);
            } else {
                cs[i].ch = (char) (55 + 6 + i);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int c = (int) s.charAt(i);
            if (c > 90) {
                c -= 61;
            } else if (c > 57) {
                c -= 55;
            } else {
                c -= 48;
            }
            cs[c].n += 1;
        }

        Arrays.sort(cs, (o1, o2) -> -Integer.compare(o1.n, o2.n));
        char[] res = new char[s.length()];
        int pos = 0;
        for (ch n: cs) {
            for (int i = 0; i < n.n; i++) {
                res[pos] = n.ch;
                pos++;
            }
        }

        return new String(res);
    }
}