/**
 * Author: Arman Yekkehkhani
 * tags: array, sort
 */

class Solution {
    List<Integer> odds = new ArrayList<>();
    List<Integer> evens = new ArrayList<>();
    int[] d;

    public int largestInteger(int num) {
        digits(num);
        Collections.sort(odds);
        Collections.sort(evens);

        int os = odds.size() - 1;
        int es = evens.size() - 1;

        int s = 0;
        for (int i = 0; i < d.length; i++) {
            int n;
            if (d[i] % 2 == 0) {
                n = evens.get(es--);
            } else {
                n = odds.get(os--);
            }
            s = s * 10 + n;
        }

        return s;
    }


    void digits(int num) {
        int n = (int) Math.log10(num) + 1;
        d = new int[n];
        while (num >= 1) {
            int dig = num % 10;
            d[n - 1] = dig;
            if (dig % 2 == 0) {
                evens.add(dig);
            } else {
                odds.add(dig);
            }
            num /= 10;
            n--;
        }
    }
}