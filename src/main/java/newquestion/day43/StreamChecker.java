package newquestion.day43;

import java.util.*;

/**
 * @author Heng Yu
 * @date 6/27/20 9:34 PM
 */

/**
 * leetcode 1032: Stream of characters
 */
public class StreamChecker {
    public static void main(String[] args) {
        String[] words = {"cd", "f", "kl"};
        StreamChecker solution = new StreamChecker(words);
        char letter = 'a';
        while (letter <= 'l') {
            if (letter == 'd') {
                System.out.println("here");
            }
            System.out.println(solution.query(letter));
            letter = (char) (letter + 1);
        }
    }

    private static class TrieNode {
        char val;
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode(char val) {
            this.val = val;
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;
    private StringBuilder history;

    public StreamChecker(String[] words) {
        root = new TrieNode(' ');
        history = new StringBuilder();

        for (String w : words) {
            buildTrie(w);
        }
    }

    private void buildTrie(String word) {
        TrieNode node = this.root;
        char[] chs = word.toCharArray();

        for (int i = chs.length - 1; i >= 0; i--) {
            char c = chs[i];
            node.children.putIfAbsent(c, new TrieNode(c));
            node = node.children.get(c);
        }

        node.isWord = true;
    }

    public boolean query(char letter) {
        StringBuilder h = this.history;
        TrieNode node = this.root;
        h.append(letter);
        for (int i = h.length() - 1; i >= 0; i--) {
            char c = h.charAt(i);
            if (!node.children.containsKey(c)) return false;
            node = node.children.get(c);
            if (node.isWord) return true;
        }

        return false;
    }
}
