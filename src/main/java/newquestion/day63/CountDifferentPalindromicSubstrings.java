package newquestion.day63;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 7/31/20 8:10 PM
 */

/**
 * leetcode 730: Count different palindromic subsequences (hard)
 * ref: https://www.bilibili.com/video/BV12W41167vQ?from=search&seid=13376393080675175148
 */
public class CountDifferentPalindromicSubstrings {
    public int countPalindromicSubsequences(String s) {
        char[] chs = s.toCharArray();
        int len = chs.length;

        final int MOD = 1000000007;

        int[][] leftMost = new int[len][4];
        int[][] rightMost = new int[len][4];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                Arrays.fill(rightMost[i], -1);
            } else {
                for (int j = 0; j < 4; j++) {
                    rightMost[i][j] = rightMost[i - 1][j];
                }
            }
            rightMost[i][chs[i] - 'a'] = i;
        }

        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                Arrays.fill(leftMost[i], len);
            } else {
                for (int j = 0; j < 4; j++) {
                    leftMost[i][j] = leftMost[i + 1][j];
                }
            }
            leftMost[i][chs[i] - 'a'] = i;
        }

        long[][] dp = new long[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i + 1 < len) {
                dp[i][i + 1] = 2;
            }
        }

        for (int w = 3; w <= len; w++) {
            for (int i = 0; i < len; i++) {
                int j = i + w - 1;
                if (j == len) break;
                if (chs[i] == chs[j]) {
                    int l = leftMost[i + 1][chs[i] - 'a'];
                    int r = rightMost[j - 1][chs[i] - 'a'];
                    if (l > r) {
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                    } else if (l == r) {
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                    } else {
                        dp[i][j] = 2 * dp[i + 1][j - 1] - dp[l + 1][r - 1];
                    }
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }

                dp[i][j] = (dp[i][j] + MOD) % MOD;
            }
        }

        return (int) dp[0][len - 1];
    }
}
