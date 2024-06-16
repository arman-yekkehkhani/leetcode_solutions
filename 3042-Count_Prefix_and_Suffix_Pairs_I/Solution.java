/**
 * Author: Arman Yekkehkhani
 * Runtime: 2ms (beats 99.57%)
 * Memory: 41.69 MB (beats 94.21%)
 * tags: :-)
 */

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int c = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((words[j].startsWith(words[i]) && words[j].endsWith(words[i]))) {
                    c++;
                }
            }
        }
        return c;
    }
}