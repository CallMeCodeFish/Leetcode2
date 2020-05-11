package newquestion.day13;

/**
 * @author Heng Yu
 * @date 5/11/20 3:54 PM
 */

/**
 * leetcode 695: Max area of island
 */
public class MaxArea {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    int cur = helper(grid, i, j, dirs);
                    res = Math.max(res, cur);
                }
            }
        }

        return res;
    }

    private int helper(int[][] grid, int i, int j, int[][] dirs) {
        grid[i][j] = -grid[i][j];
        int res = 1;
        int m = grid.length;
        int n = grid[0].length;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] > 0) {
                res += helper(grid, ni, nj, dirs);
            }
        }

        return res;
    }
}
