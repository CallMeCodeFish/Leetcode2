package day1;

/**
 * @author Heng Yu
 * @date 2/26/20 7:21 PM
 */

/**
 * leetcode 5: Longest Palindromic Substring
 *
 */

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String result = solution.longestPalindrome("cbbd");
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        //edge case
        if (s == null || s.isEmpty())
            return "";

        String res = "";
        for (int i = 0; i < s.length(); ++i) {
            String str = expandFromCenter(i, i, s);
            res = (res.length() < str.length())? str : res;
            str = expandFromCenter(i, i + 1, s);
            res = (res.length() < str.length())? str : res;
        }
        return res;
    }

    private String expandFromCenter(int l, int r, String s) {
        if (r == s.length())
            return s.substring(l, r);

        if (l != r) {
            if (s.charAt(l) != s.charAt(r))
                return "";
        }
        while (0 <= l && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            --l;
            ++r;
        }
        return s.substring(l + 1, r);
    }
}
