package newquestion.day17;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Heng Yu
 * @date 5/16/20 4:21 PM
 */

/**
 * leetcode 1268: Search suggestions system
 */
public class SearchSuggestions {
    private static class TrieNode {
        char c;
        boolean isWord;
        TreeMap<Character, TrieNode> children;

        public TrieNode() {
            this.c = (char) (0);
            this.isWord = false;
            this.children = new TreeMap<>();
        }

        public TrieNode(char c) {
            this.c = c;
            this.isWord = false;
            this.children = new TreeMap<>();
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();

        for (String product : products) {
            buildTrie(root, product);
        }

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); ++i) {
            res.add(new ArrayList<>());
        }

        char[] chs = searchWord.toCharArray();
        TrieNode cur = root;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; ++i) {
            char c = chs[i];
            if (!cur.children.containsKey(c)) break;

            cur = cur.children.get(c);
            helper(cur, res.get(i), sb);
            sb.append(c);
        }

        return res;
    }

    private void helper(TrieNode node, List<String> list, StringBuilder sb) {
        if (list.size() == 3) return;

        sb.append(node.c);
        if (node.isWord) {
            list.add(sb.toString());
        }

        TreeMap<Character, TrieNode> children = node.children;
        for (Map.Entry<Character, TrieNode> e : children.entrySet()) {
            TrieNode child = e.getValue();
            helper(child, list, sb);
        }

        sb.deleteCharAt(sb.length() - 1);
    }

    private void buildTrie(TrieNode root, String word) {
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            char c = chs[i];
            if (!root.children.containsKey(c)) {
                root.children.put(c, new TrieNode(c));
            }
            root = root.children.get(c);
            if (i == chs.length - 1) {
                root.isWord = true;
            }
        }
    }
}
