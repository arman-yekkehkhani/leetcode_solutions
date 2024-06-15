/**
 * Author: Arman Yekkehkhani
 * Runtime: 261ms (beats 5.03%)
 * Memory: 48.86 MB (beats 32.56%)
 * tags: trie, dfs
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        String[] prod = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String sw = "mouse";
        Solution solution = new Solution();
        solution.suggestedProducts(prod, sw);
    }

    class Node {
        String word;
        // 97 - 122
        Node[] sub = new Node[26];
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Node root = new Node();
        Node current;

        for (String p : products) {
            current = root;
            for (int i = 0; i < p.length(); i++) {
                int idx = p.charAt(i) - 97;
                if (current.sub[idx] == null) {
                    current.sub[idx] = new Node();
                }
                current = current.sub[idx];
            }
            current.word = p;
        }

        List<List<String>> res = new ArrayList<>();
        current = root;
        int i;
        for (i = 0; i < searchWord.length(); i++) {
            List<String> word3 = new ArrayList<>();
            int idx = searchWord.charAt(i) - 97;
            if (current.sub[idx] == null) {
                for (int j = i; j < searchWord.length(); j++) {
                    res.add(new ArrayList<>());
                }
                break;
            }
            current = current.sub[idx];
            dfs(current, word3);
            res.add(word3);
        }

        return res;
    }

    void dfs(Node n, List<String> l) {
        if (n == null || l.size() >= 3) {
            return;
        }
        if (n.word != null) {
            l.add(n.word);
        }
        for (Node nn : Arrays.stream(n.sub).filter(Objects::nonNull).toList()) {
            dfs(nn, l);
        }
    }
}