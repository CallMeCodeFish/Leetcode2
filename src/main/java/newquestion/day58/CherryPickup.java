package newquestion.day58;

/**
 * @author Heng Yu
 * @date 7/20/20 9:21 PM
 */

/**
 * leetcode 741: Cherry pickup (hard)
 * solution: recursion + memorization
 * ref: https://www.bilibili.com/video/BV1tW41167jy?from=search&seid=17624102435939004057
 */
public class CherryPickup {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return Math.max(0, helper(grid, 0, 0, 0, dp));
    }

    private int helper(int[][] grid, int x1, int y1, int x2, int[][][] dp) {
        int n = grid.length;

        int y2 = x1 + y1 - x2;

        if (x1 == n || y1 == n || x2 == n || y2 == n) return -2;

        if (dp[x1][y1][x2] != -1) return dp[x1][y1][x2];

        if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            dp[x1][y1][x2] = -2;
            return -2;
        }

        if (x1 == n - 1 && y1 == n - 1) {
            dp[x1][y1][x2] = grid[x1][y1];
            return grid[x1][y1];
        }

        int res = helper(grid, x1, y1 + 1, x2, dp); //right right
        res = Math.max(res, helper(grid, x1, y1 + 1, x2 + 1, dp)); //right down
        res = Math.max(res, helper(grid, x1 + 1, y1, x2, dp)); //down right
        res = Math.max(res, helper(grid, x1 + 1, y1, x2 + 1, dp)); //down down

        if (res == -2) {
            dp[x1][y1][x2] = -2;
            return -2;
        }

        res += x1 == x2 ? grid[x1][y1] : grid[x1][y1] + grid[x2][y2];
        dp[x1][y1][x2] = res;
        return res;
    }
}
