package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 5/28/20 7:35 PM
 */

/**
 * leetcode 642: Design search autocomplete system
 */
public class AutocompleteSystem {
    private static class TrieNode {
        char c;
        boolean isWord;
        Map<Character, TrieNode> children;
        String sentence;
        int time;

        public TrieNode() {
            this.c = '\0';
            this.isWord = false;
            this.children = new HashMap<>();
            this.sentence = null;
            this.time = 0;
        }

        public TrieNode(char c) {
            this.c = c;
            this.isWord = false;
            this.children = new HashMap<>();
            this.sentence = null;
            this.time = 0;
        }
    }

    private TrieNode root;
    private TrieNode cur;
    private StringBuilder sb;


    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        cur = root;
        sb = new StringBuilder();

        int len = sentences.length;

        for (int i = 0; i < len; i++) {
            addSentence(sentences[i], times[i]);
        }
    }

    private void addSentence(String s, int time) {
        TrieNode pred = root;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            Map<Character, TrieNode> children = pred.children;
            if (!children.containsKey(c)) {
                children.put(c, new TrieNode(c));
            }
            pred = pred.children.get(c);
            if (i == chs.length - 1) {
                pred.isWord = true;
                pred.sentence = s;
                pred.time = time;
            }
        }
    }

    public List<String> input(char c) {

        List<TrieNode> nodes = new ArrayList<>();
        List<String> res = new ArrayList<>();

        if (c == '#') {
            if (cur.isWord) {
                cur.time++;
            } else {
                cur.isWord = true;
                cur.time = 1;
                cur.sentence = sb.toString();
            }
            cur = root;
            sb.delete(0, sb.length());
        } else {
            sb.append(c);
            Map<Character, TrieNode> children = cur.children;
            if (children.containsKey(c)) {
                cur = children.get(c);
                autocomplete(cur, nodes);
                nodes.sort((a, b) -> (a.time != b.time)? b.time - a.time : a.sentence.compareTo(b.sentence));
                for (int i = 0; i < 3; ++i) {
                    if (i == nodes.size()) break;
                    res.add(nodes.get(i).sentence);
                }
            } else {
                children.put(c, new TrieNode(c));
                cur = children.get(c);
            }
        }

        return res;
    }

    private void autocomplete(TrieNode node, List<TrieNode> nodes) {
        if (node.isWord) nodes.add(node);

        Map<Character, TrieNode> children = node.children;
        for (Character c : children.keySet()) {
            TrieNode next = children.get(c);
            autocomplete(next, nodes);
        }
    }
}
