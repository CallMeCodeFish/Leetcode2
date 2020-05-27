package hard;

/**
 * @author Heng Yu
 * @date 5/27/20 6:20 PM
 */

/**
 * leetcode 97: Interleaving string
 * Solution: two-dimensional dynamic programming
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;

        int m = s1.length();
        int n = s2.length();
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        char[] chs3 = s3.toCharArray();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j < n + 1; ++j) {
            if (dp[0][j - 1] && chs2[j - 1] == chs3[j - 1]) dp[0][j] = true;
        }

        for (int i = 1; i < m + 1; ++i) {
            if (dp[i - 1][0] && chs1[i - 1] == chs3[i - 1]) dp[i][0] = true;
        }

        for (int i = 1; i < m + 1; ++i) {
            for (int j = 1; j < n + 1; ++j) {
                if (dp[i][j - 1] && chs2[j - 1] == chs3[i + j - 1] || dp[i - 1][j] && chs1[i - 1] == chs3[i + j - 1]) dp[i][j] = true;
            }
        }

        return dp[m][n];
    }
}
