package newquestion.day26;

/**
 * @author Heng Yu
 * @date 6/1/20 8:30 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 340: Longest substring with at most k distinct characters (hard)
 */
public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();
        int result = solution.lengthOfLongestSubstringKDistinct("eceba", 2);
        System.out.println(result);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] chs = s.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int res = 0;

        while (j < chs.length) {
            map.put(chs[j], map.getOrDefault(chs[j], 0) + 1);
            if (map.size() == k + 1) {
                while (i <= j) {
                    map.replace(chs[i], map.get(chs[i]) - 1);
                    if (map.get(chs[i]) == 0) {
                        map.remove(chs[i]);
                        i++;
                        break;
                    }
                    i++;
                }
            }
            res = Math.max(res, j - i + 1);
            j++;
        }

        return res;
    }
}
