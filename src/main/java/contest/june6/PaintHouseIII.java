package contest.june6;

/**
 * @author Heng Yu
 * @date 6/6/20 11:16 PM
 */

//ref: https://leetcode.com/problems/paint-house-iii/discuss/674531/Java-Bottom-Up-Dp
public class PaintHouseIII {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m + 1][target + 1][n + 1];
        final int MAX_VALUE = 1000000;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = MAX_VALUE;
                }
            }
        }

        int color = houses[0];
        if (color == 0) {
            for (int k = 1; k <= n; k++) {
                dp[1][1][k] = cost[0][k - 1];
            }
        } else {
            dp[1][1][color] = 0;
        }

        for (int i = 2; i <= m; i++) {
            color = houses[i - 1];
            if (color == 0) {
                for (int j = 1; j <= target; j++) {
                    for (int k = 1; k <= n; k++) {
                        for (int x = 1; x <= n; x++) {
                            if (k == x) {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k] + cost[i - 1][k - 1]);
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - 1][x] + cost[i - 1][k - 1]);
                            }
                        }
                    }
                }
            } else {
                for (int j = 1; j <= target; j++) {
                    for (int k = 1; k <= n; k++) {
                        if (color == k) {
                            dp[i][j][color] = Math.min(dp[i][j][color], dp[i - 1][j][color]);
                        } else {
                            dp[i][j][color] = Math.min(dp[i][j][color], dp[i - 1][j - 1][k]);
                        }
                    }
                }
            }
        }

        color = houses[m - 1];
        int res = MAX_VALUE;
        if (color == 0) {
            for (int k = 1; k <= n; k++) {
                res = Math.min(res, dp[m][target][k]);
            }
        } else {
            res = dp[m][target][color];
        }

        return (res == MAX_VALUE)? -1 : res;
    }
}
