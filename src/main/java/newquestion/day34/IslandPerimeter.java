package newquestion.day34;

/**
 * @author Heng Yu
 * @date 6/11/20 5:00 PM
 */

/**
 * leetcode 463: Island perimeter
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter solution = new IslandPerimeter();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int result = solution.islandPerimeter(grid);
        System.out.println(result);
    }

    private int res = 0;

    public int islandPerimeter(int[][] grid) {
        //edge case

        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, dirs);
                    break;
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j, int[][] dirs) {
        grid[i][j] = -grid[i][j];

        int m = grid.length;
        int n = grid[0].length;

        int neighborCount = 0;
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] != 0) neighborCount++;
        }

        res += 4 - neighborCount;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) dfs(grid, ni, nj, dirs);
        }
    }
}
