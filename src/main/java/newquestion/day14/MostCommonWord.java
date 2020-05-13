package newquestion.day14;

/**
 * @author Heng Yu
 * @date 5/12/20 2:11 PM
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 819: Most common word
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String s : banned) {
            set.add(s);
        }

        Map<String, Integer> map = new HashMap<>();

        char[] chs = paragraph.toCharArray();

        int i = 0;
        int maxCount = 0;
        while (i < chs.length) {
            if (Character.isLetter(chs[i])) {
                int j = i + 1;
                while (j < chs.length && Character.isLetter(chs[j])) {
                    ++j;
                }
                String word = String.valueOf(chs, i, j - i).toLowerCase();
                if (!set.contains(word)) {
                    int count = map.getOrDefault(word, 0);
                    map.put(word, count + 1);
                    maxCount = Math.max(maxCount, map.get(word));
                }
                i = j;
            } else {
                ++i;
            }
        }

        String res = "";

        for (String word : map.keySet()) {
            if (map.get(word) == maxCount) {
                res = word;
                break;
            }
        }

        return res;
    }
}
