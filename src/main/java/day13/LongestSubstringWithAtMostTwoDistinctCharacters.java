package day13;

/**
 * @author Heng Yu
 * @date 3/10/20 5:34 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 159: Longes tSubstring With AtMost Two Distinct Characters
 */

public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static void main(String[] args) {
        LongestSubstringWithAtMostTwoDistinctCharacters solution = new LongestSubstringWithAtMostTwoDistinctCharacters();
        int result = solution.lengthOfLongestSubstringTwoDistinct("abZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZYX");
        System.out.println(result);
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //edge case
        if (s == null || s.isEmpty()) return 0;

        int[] counts = new int[128];
        char[] chs = s.toCharArray();
        int i = 0;
        int j = 0;
        int res = 0;
        int distinct = 0;
        while (j < chs.length) {
            int ch1 = chs[j];
            if (counts[ch1] == 0) ++distinct;
            ++counts[ch1];
            if (distinct == 3) {
                while (i <= j) {
                    int ch2 = chs[i];
                    --counts[ch2];
                    ++i;
                    if (counts[ch2] == 0) --distinct;
                    if (distinct < 3) break;
                }
            }
            res = Math.max(res, j - i + 1);
            ++j;
        }
        return res;
    }
}
