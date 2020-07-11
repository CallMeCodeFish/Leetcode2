package newquestion.day52;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 7/11/20 6:47 PM
 */

/**
 * leetcode 115: Distinct subsequences
 */
public class DistinctSubsequences {
    /**
     * dp solution
     * @param s
     * @param t
     * @return
     */
    public int numDistinct1(String s, String t) {
        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();
        int m = chs1.length;
        int n = chs2.length;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (chs1[i - 1] == chs2[j - 1]) dp[i][j] += dp[i - 1][j - 1];
            }
        }

        return dp[m][n];
    }

    /**
     * recursion + memorization
     * @param s
     * @param t
     * @return
     */
    public int numDistinct2(String s, String t) {
        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();

        int[][] memo = new int[chs1.length][chs2.length];
        for (int i = 0; i < chs1.length; i++) {
            Arrays.fill(memo[i], -1);
        }

        return helper(chs1, 0, chs2, 0, memo);
    }

    private int helper(char[] s, int i, char[] t, int j, int[][] memo) {
        if (j == t.length) return 1;
        if (s.length - i < t.length - j) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        int res = 0;

        if (s[i] == t[j]) {
            res += helper(s, i + 1, t, j + 1, memo);
        }

        res += helper(s, i + 1, t, j, memo);

        memo[i][j] = res;
        return res;
    }
}
