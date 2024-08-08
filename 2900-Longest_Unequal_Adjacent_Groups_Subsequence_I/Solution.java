/**
 * Author: Arman Yekkehkhani
 * Runtime: 2 ms (beats 16.82 %)
 * Memory: 45.09 MB (beats 21.54 %)
 * tags: dynamic programming, greedy
 */

// dp approach
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int[] maxSeq = new int[groups.length + 1];
        int[] relation = new int[groups.length];
        maxSeq[maxSeq.length - 1] = 0;
        for (int i = maxSeq.length - 2; i >= 0; i--) {
            int max = 0;
            int relIdx = i;
            for (int j = i + 1; j < maxSeq.length; j++) {
                if (j >= groups.length || groups[i] != groups[j]) {
                    if (1 + maxSeq[j] > max) {
                        max = 1 + maxSeq[j];
                        relIdx = j;
                    }
                }
            }
            maxSeq[i] = max;
            relation[i] = relIdx;
        }

        int maxLen = 0;
        int maxIdx = 0;
        for (int i = 0; i < maxSeq.length; i++) {
            if (maxLen < maxSeq[i]) {
                maxLen = maxSeq[i];
                maxIdx = i;
            }
        }

        List<String> res = new ArrayList<>();
        int idx = maxIdx;
        while (idx != maxSeq.length - 1) {
            res.add(words[idx]);
            idx = relation[idx];
        }

        return res;
    }
}

//greedy
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        for (int i = 0; i < groups.length - 1; i++) {
            if (groups[i] != groups[i + 1]) {
                res.add(words[i + 1]);
            }
        }
        return res;
    }
}