package day31;

/**
 * @author Heng Yu
 * @date 4/7/20 4:29 PM
 */

/**
 * leetcode 361: Bomb Enemy
 */

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        //edge case
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        for (int i = 0; i < m; ++i) {
            //left
            for (int j = 1; j < n; ++j) {
                if (grid[i][j - 1] == '0') {
                    left[i][j] = left[i][j - 1];
                } else if (grid[i][j - 1] == 'E') {
                    left[i][j] = left[i][j - 1] + 1;
                }
            }
            //right
            for (int j = n - 2; j >= 0; --j) {
                if (grid[i][j + 1] == '0') {
                    right[i][j] = right[i][j + 1];
                } else if (grid[i][j + 1] == 'E') {
                    right[i][j] = right[i][j + 1] + 1;
                }
            }
        }
        for (int j = 0; j < n; ++j) {
            //up
            for (int i = 1; i < m; ++i) {
                if (grid[i - 1][j] == '0') {
                    up[i][j] = up[i - 1][j];
                } else if (grid[i - 1][j] == 'E') {
                    up[i][j] = up[i - 1][j] + 1;
                }
            }
            //down
            for (int i = m - 2; i >= 0; --i) {
                if (grid[i + 1][j] == '0') {
                    down[i][j] = down[i + 1][j];
                } else if (grid[i + 1][j] == 'E') {
                    down[i][j] = down[i + 1][j] + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '0') {
                    int cur = left[i][j] + right[i][j] + up[i][j] + down[i][j];
                    res = Math.max(res, cur);
                }
            }
        }
        return res;
    }
}
