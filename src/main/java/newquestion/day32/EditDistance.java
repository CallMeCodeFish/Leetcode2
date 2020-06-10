package newquestion.day32;

/**
 * @author Heng Yu
 * @date 6/9/20 8:19 PM
 */

import java.util.Arrays;

/**
 * leetcode 72: Edit distance
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        char[] chs1 = word1.toCharArray();
        char[] chs2 = word2.toCharArray();
        int m = chs1.length;
        int n = chs2.length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                dp[i][j] = Math.min(dp[i][j], (dp[i - 1][j - 1] + (chs1[i - 1] == chs2[j - 1]? 0 : 1)));
            }
        }

        return dp[m][n];
    }
}
