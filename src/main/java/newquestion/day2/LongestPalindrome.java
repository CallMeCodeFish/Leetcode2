package newquestion.day2;

/**
 * @author Heng Yu
 * @date 4/25/20 9:46 PM
 */

/**
 * leetcode 409: Longest Palindrome
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        //edge case

        int[] count = new int[128];
        char[] chs = s.toCharArray();

        for (char c : chs) {
            ++count[c];
        }

        int res = 0;
        for (int i = 0; i < count.length; ++i) {
            if (count[i] != 0) {
                if (count[i] % 2 == 0) {
                    res += count[i];
                } else if (count[i] > 1) {
                    res += count[i] - 1;
                }
            }
        }

        return (chs.length - res > 0)? res + 1 : res;
    }
}
