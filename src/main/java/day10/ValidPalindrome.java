package day10;

/**
 * @author Heng Yu
 * @date 3/6/20 4:16 PM
 */

/**
 * leetcode 125: Valid Palindrome
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        //edge case
        if (s == null || s.isEmpty()) return true;

        char[] chs = s.toCharArray();
        int i = 0;
        int j = chs.length - 1;
        while (i <= j) {
            if (!Character.isLetterOrDigit(chs[i]) && !Character.isLetterOrDigit(chs[j])) {
                ++i;
                --j;
            } else if (!Character.isLetterOrDigit(chs[i])) {
                ++i;
            } else if (!Character.isLetterOrDigit(chs[j])) {
                --j;
            } else {
                char ch1 = Character.toLowerCase(chs[i++]);
                char ch2 = Character.toLowerCase(chs[j--]);
                if (ch1 != ch2) return false;
            }
        }
        return true;
    }
}
