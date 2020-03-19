package day22;

/**
 * @author Heng Yu
 * @date 3/19/20 6:23 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 290: Word Pattern
 */

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;

        char[] pats = pattern.toCharArray();
        Map<String, Character> mapper = new HashMap<>();
        boolean[] used = new boolean[26];
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            char ch = pats[i];
            if (!mapper.containsKey(word)) {
                if (used[ch - 'a']) return false;
                used[ch- 'a'] = true;
                mapper.put(word, ch);
            } else {
                if (ch != mapper.get(word)) return false;
            }
        }
        return true;
    }
}
