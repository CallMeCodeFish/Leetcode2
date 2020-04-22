package day34;

/**
 * @author Heng Yu
 * @date 4/21/20 11:04 PM
 */

/**
 * leetcode 395: Longest Substring with at least K Repeating Characters
 */
public class LongestSubstringWithAtLeastKRepeating {
    public int longestSubstring(String s, int k) {
        if (s == null) return 0;
        return helper(s, k);
    }

    private int helper(String s, int k) {
        //edge case
        if (s.isEmpty()) return 0;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int index = s.charAt(i) - 'a';
            ++count[index];
        }
        boolean flag = true;
        for (int i = 0; i < count.length; ++i) {
            if (count[i] > 0 && count[i] < k) {
                flag = false;
                break;
            }
        }
        if (flag) return s.length();

        int i = 0, j = 0;
        int max = 0;
        while (j < s.length()) {
            int index = s.charAt(j) - 'a';
            if (count[index] < k) {
                int length = helper(s.substring(i, j), k);
                max = Math.max(max, length);
                i = j + 1;
            }
            ++j;
        }
        if (i < s.length()) {
            int length = helper(s.substring(i), k);
            max = Math.max(max, length);
        }
        return max;
    }
}
