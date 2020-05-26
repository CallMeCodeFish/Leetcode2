package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 5/25/20 6:09 PM
 */

/**
 * leetcode 472: Concatenated words
 * Solution: prefix tree
 */
public class ConcatenatedWords {
    public static void main(String[] args) {
        ConcatenatedWords solution = new ConcatenatedWords();
        String[] words = {""};
        List<String> result = solution.findAllConcatenatedWordsInADict(words);
        System.out.println(result.size());
    }

    private static class TrieNode {
        char value;
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode(char value) {
            this.value = value;
            this.isWord = false;
            this.children = new HashMap<>();
        }

        public TrieNode() {
            this.value = '\0';
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            buildTree(root, word);
        }

        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (isConcatenated(root, root, word.toCharArray(), 0, 0)) res.add(word);
        }

        return res;
    }

    private boolean isConcatenated(TrieNode node, TrieNode root, char[] chs, int start, int flag) {
        if (start == chs.length) return flag > 1;

        for (int i = start; i < chs.length; ++i) {
            char c = chs[i];
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
            if (node.isWord && isConcatenated(root, root, chs, i + 1, flag + 1)) return true;
        }

        return false;
    }

    private void buildTree(TrieNode root, String word) {
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; ++i) {
            char c = chs[i];
            if (!root.children.containsKey(c)) {
                root.children.put(c, new TrieNode(c));
            }
            root = root.children.get(c);
            if (i == chs.length - 1) root.isWord = true;
        }
    }
}
