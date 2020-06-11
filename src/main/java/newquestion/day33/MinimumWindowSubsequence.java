package newquestion.day33;

/**
 * @author Heng Yu
 * @date 6/10/20 7:25 PM
 */

import java.util.Arrays;

/**
 * leetcode 727: Minimum window subsequence
 */
public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        MinimumWindowSubsequence solution = new MinimumWindowSubsequence();
        String result = solution.minWindow("abcdebdde", "bde");
        System.out.println(result);
    }

    public String minWindow(String S, String T) {
        char[] chs1 = S.toCharArray();
        char[] chs2 = T.toCharArray();

        int m = chs1.length;
        int n = chs2.length;

        final int MAX_VALUE = 20001;

        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], MAX_VALUE);
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int num = (chs1[i - 1] == chs2[j - 1]) ? dp[i - 1][j - 1] + 1 : MAX_VALUE;
                dp[i][j] = Math.min(dp[i - 1][j] + 1, num);
            }
        }

        int minLen = MAX_VALUE;
        int start = 0;
        for (int i = 0; i <= m; i++) {
            if (dp[i][n] < minLen) {
                minLen = dp[i][n];
                start = i - minLen;
            }
        }

        if (minLen == MAX_VALUE) return "";

        return S.substring(start, start + minLen);
    }
}
