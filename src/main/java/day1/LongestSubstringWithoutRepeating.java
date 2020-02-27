package day1;

/**
 * @author Heng Yu
 * @date 2/26/20 6:42 PM
 */

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 3: Longest Substring Without Repeating Characters
 *
 */

public class LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();
        int result = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        //edge case
        if (s == null || s.isEmpty())
            return 0;

        Set<Character> set = new HashSet<>();
        char[] chs = s.toCharArray();
        int res = 0;
        int i = 0;
        int j = 0;
        while (j < chs.length) {
            char ch = chs[j];
            while (set.contains(ch)) {
                set.remove(chs[i++]);
            }
            set.add(ch);
            res = Math.max(res, j - i + 1);
            ++j;
        }
        return res;
    }
}
