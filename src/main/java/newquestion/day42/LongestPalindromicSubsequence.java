package newquestion.day42;

/**
 * @author Heng Yu
 * @date 6/23/20 5:30 PM
 */

/**
 * leetcode 516: Longest palindromic subsequence
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 1) return 1;

        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                dp[i][j] = 1;
            }
        }

        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = Math.max(dp[i][j], 2 + dp[i + 1][j - 1]);
            }
        }

        return dp[0][len - 1];
    }
}
