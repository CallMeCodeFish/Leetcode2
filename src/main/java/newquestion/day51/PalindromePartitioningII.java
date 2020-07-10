package newquestion.day51;

/**
 * @author Heng Yu
 * @date 7/9/20 8:30 PM
 */

/**
 * leetcode 132: Palindrome partitioning II
 * ref: https://www.bilibili.com/video/BV1NJ411v7k9?from=search&seid=17196022073775733924
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        char[] chs = s.toCharArray();
        boolean[][] palindrome = buildPalindrome(chs);
        int len = chs.length;
        int[] dp = new int[len + 1];

        for (int i = 2; i <= len; i++) {
            dp[i] = i - 1;
            for (int j = i; j > 0; j--) {
                if (palindrome[j - 1][i - 1]) {
                    dp[i] = j == 1 ? Math.min(dp[i], dp[j - 1]) : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[len];
    }

    private boolean[][] buildPalindrome(char[] chs) {
        int n = chs.length;
        boolean[][] res = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = true;
            if (i + 1 < n && chs[i] == chs[i + 1]) res[i][i + 1] = true;
        }

        for (int d = 2; d < n; d++) {
            for (int i = 0; i < n; i++) {
                int j = i + d;
                if (j >= n) break;
                if (chs[i] == chs[j] && res[i + 1][j - 1]) res[i][j] = true;
            }
        }

        return res;
    }
}
