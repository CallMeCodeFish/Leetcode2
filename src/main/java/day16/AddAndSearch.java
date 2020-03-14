package day16;

/**
 * @author Heng Yu
 * @date 3/13/20 10:50 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 211: Add and Search Word
 */

public class AddAndSearch {
    public static void main(String[] args) {
        AddAndSearch solution = new AddAndSearch();
        solution.addWord("bad");
        solution.addWord("dad");
        solution.addWord("mad");
        boolean result = solution.search("b..");
        System.out.println(result);
    }

    private class TrieNode {
        char ch;
        boolean isWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            this.ch = '\0';
            this.isWord = false;
            this.children = new HashMap<>();
        }

        public TrieNode(char ch) {
            this.ch = ch;
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public AddAndSearch() {
        this.root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode(ch));
            }
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        return dfs(root, chs, 0);
    }

    private boolean dfs(TrieNode cur, char[] chs, int i) {
        //edge case
        if (i == chs.length) return cur.isWord;

        char ch = chs[i];
        if (ch == '.') {
            if (cur.children.isEmpty()) return false;
            for (TrieNode next : cur.children.values()) {
                if (dfs(next, chs, i + 1)) return true;
            }
        } else {
            if (!cur.children.containsKey(ch)) return false;
            return dfs(cur.children.get(ch), chs, i + 1);
        }
        return false;
    }
}
