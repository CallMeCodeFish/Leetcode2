package day5;

/**
 * @author Heng Yu
 * @date 3/1/20 11:39 PM
 */

/**
 * leetcode 64: Minimum Path Sum
 */

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i + 1 < m && j + 1 < n) {
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                } else if (i + 1 < m) {
                    grid[i][j] += grid[i + 1][j];
                } else if (j + 1 < n) {
                    grid[i][j] += grid[i][j + 1];
                }
            }
        }
        return grid[0][0];
    }
}
