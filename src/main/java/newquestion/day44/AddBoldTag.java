package newquestion.day44;

/**
 * @author Heng Yu
 * @date 6/28/20 6:56 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 616: Add bold tag in string
 */
public class AddBoldTag {
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

    private void buildTrie(TrieNode node, String word) {
        char[] chs = word.toCharArray();
        for (char c : chs) {
            node.children.putIfAbsent(c, new TrieNode(c));
            node = node.children.get(c);
        }

        node.isWord = true;
    }

    private boolean isExisted(char[] chs, int[] interval, TrieNode node) {
        int l = interval[0];
        int r = interval[1];
        boolean res = false;
        for (int i = l; i < r; i++) {
            char c = chs[i];
            if (!node.children.containsKey(c)) break;
            node = node.children.get(c);
            if (node.isWord) {
                interval[1] = i;
                res = true;
            }
        }

        return res;
    }

    public String addBoldTag(String s, String[] dict) {
        TrieNode root = new TrieNode(' ');

        for (String w : dict) {
            buildTrie(root, w);
        }

        char[] chs = s.toCharArray();
        boolean[] isPart = new boolean[chs.length];

        for (int i = 0; i < chs.length; i++) {
            int[] interval = new int[]{i, chs.length};
            if (isExisted(chs, interval, root)) {
                for (int j = i; j <= interval[1]; j++) {
                    isPart[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < chs.length) {
            if (!isPart[i]) {
                sb.append(chs[i]);
                i++;
            } else {
                sb.append("<b>");
                while (i < chs.length && isPart[i]) {
                    sb.append(chs[i]);
                    i++;
                }
                sb.append("</b>");
            }
        }

        return sb.toString();
    }
}
