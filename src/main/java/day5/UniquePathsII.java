package day5;

/**
 * @author Heng Yu
 * @date 3/1/20 11:28 PM
 */

/**
 * leetcode 63: Unique Paths II
 */

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i + 1 < m) {
                        dp[i][j] += dp[i + 1][j];
                    }
                    if (j + 1 < n) {
                        dp[i][j] += dp[i][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }
}
