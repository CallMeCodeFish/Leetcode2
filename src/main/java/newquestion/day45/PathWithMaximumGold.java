package newquestion.day45;

/**
 * @author Heng Yu
 * @date 6/29/20 1:55 PM
 */

/**
 * leetcode 1219: Path with maximum gold
 */
public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    int cur = backtracking(grid, i, j, visited, dirs);
                    res = Math.max(res, cur);
                }
            }
        }

        return res;
    }

    private int backtracking(int[][] grid, int i, int j, boolean[][] visited, int[][] dirs) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        visited[i][j] = true;

        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] != 0 && !visited[ni][nj]) {
                int cur = backtracking(grid, ni, nj, visited, dirs);
                res = Math.max(res, cur);
            }
        }

        visited[i][j] = false;

        return res + grid[i][j];
    }
}
