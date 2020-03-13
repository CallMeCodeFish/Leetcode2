package day15;

/**
 * @author Heng Yu
 * @date 3/12/20 9:41 PM
 */

/**
 * leetcode 200: Number of Islands
 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        //edge case
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    ++res;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;
        if (0 < i && grid[i - 1][j] == '1' && !visited[i - 1][j]) dfs(grid, i - 1, j, visited);
        if (i < m - 1 && grid[i + 1][j] == '1' && !visited[i + 1][j]) dfs(grid, i + 1, j, visited);
        if (0 < j && grid[i][j - 1] == '1' && !visited[i][j - 1]) dfs(grid, i, j - 1, visited);
        if (j < n - 1 && grid[i][j + 1] == '1' && !visited[i][j + 1]) dfs(grid, i, j + 1, visited);
    }
}
