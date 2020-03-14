package day16;

/**
 * @author Heng Yu
 * @date 3/13/20 8:41 PM
 */

/**
 * leetcode 208: Implement Trie (Prefix Tree)
 */

public class PrefixTree {
    private class TrieNode {
        char ch;
        boolean isWord;
        TrieNode[] children;

        public TrieNode() {
            this.ch = '\0';
            this.isWord = false;
            this.children = new TrieNode[26];
        }

        public TrieNode(char ch) {
            this.ch = ch;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public PrefixTree() {
        this.root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            int index = ch - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode(ch);
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            int index = ch - 'a';
            if (cur.children[index] == null) return false;
            cur = cur.children[index];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chs = prefix.toCharArray();
        TrieNode cur = root;
        for (char ch : chs) {
            int index = ch - 'a';
            if (cur.children[index] == null) return false;
            cur = cur.children[index];
        }
        return true;
    }
}
