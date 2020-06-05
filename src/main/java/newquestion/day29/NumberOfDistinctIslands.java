package newquestion.day29;

/**
 * @author Heng Yu
 * @date 6/4/20 6:46 PM
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 694: Number of distinct islands
 * solution: 同样结构的连通域进行bfs时，遍历的相对先后顺序一致
 */
public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        Set<String> visited = new HashSet<>();
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    int[] pair = new int[2];
                    dfs(grid, i, j, i, j, pair, sb, dirs);
                    sb.deleteCharAt(sb.length() - 1);
                    String s = sb.toString();
                    visited.add(s);
                }
            }
        }

        return visited.size();
    }

    private void dfs(int[][] grid, int x, int y, int sx, int sy, int[] pair, StringBuilder sb, int[][] dirs) {
        int m = grid.length;
        int n = grid[0].length;

        grid[x][y] = -grid[x][y];
        pair[0] = x - sx;
        pair[1] = y - sy;
        sb.append(Arrays.toString(pair));
        sb.append(',');

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) dfs(grid, nx, ny, sx, sy, pair, sb, dirs);
        }
    }
}
