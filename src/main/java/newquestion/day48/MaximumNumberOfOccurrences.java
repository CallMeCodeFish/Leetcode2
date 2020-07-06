package newquestion.day48;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 7/5/20 7:56 PM
 */

/**
 * leetcode 1297: Maximum number of occurrences of a substring
 * solution: sliding window
 */
public class MaximumNumberOfOccurrences {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int[] freq = new int[26];
        int len = s.length();

        int i = 0, j = 0;
        Map<String, Integer> map = new HashMap<>();
        int letters = 0;

        while (j < len) {
            int index = s.charAt(j) - 'a';
            if (++freq[index] == 1) letters++;

            while (letters > maxLetters) {
                index = s.charAt(i++) - 'a';
                if (--freq[index] == 0) {
                    letters--;
                    break;
                }
            }

            while (i < j && j - i + 1 > minSize) {
                index = s.charAt(i) - 'a';
                if (--freq[index] == 0) letters--;
                i++;
            }

            if (j - i + 1 == minSize) {
                String target = s.substring(i, j + 1);
                map.put(target, map.getOrDefault(target, 0) + 1);
            }

            j++;
        }

        int res = 0;

        for (String key : map.keySet()) {
            res = Math.max(res, map.get(key));
        }

        return res;
    }
}
