package newquestion.day11;

/**
 * @author Heng Yu
 * @date 5/8/20 5:38 PM
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1048: Longest string chain
 */
public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int res = 1;

        for (String word : words) {
            if (word.length() == words[0].length()) {
                map.put(word, 1);
            } else {
                map.put(word, 1);
                for (int i = 0; i < word.length(); ++i) {
                    String pred = word.substring(0, i) + word.substring(i + 1);
                    if (map.containsKey(pred)) {
                        map.replace(word, Math.max(map.get(word), map.get(pred) + 1));
                        res = Math.max(res, map.get(word));
                    }
                }
            }
        }

        return res;
    }
}
