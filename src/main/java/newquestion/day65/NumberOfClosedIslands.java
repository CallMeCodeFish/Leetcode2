package newquestion.day65;

/**
 * @author Tim
 * @date 8/5/20 6:17 PM
 */

/**
 * leetcode 1254: Number of closed islands
 */
public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) dfs(grid, i, 0, dirs);
            if (grid[i][n - 1] == 0) dfs(grid, i, n - 1, dirs);
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 0) dfs(grid, 0, j, dirs);
            if (grid[m - 1][j] == 0) dfs(grid, m - 1, j, dirs);
        }

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j, dirs);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j, int[][] dirs) {
        grid[i][j] = 1;
        int m = grid.length;
        int n = grid[0].length;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 0) dfs(grid, ni, nj, dirs);
        }
    }
}
