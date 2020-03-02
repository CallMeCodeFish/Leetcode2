package day5;

/**
 * @author Heng Yu
 * @date 3/1/20 10:47 PM
 */

/**
 * leetcode 62: Unique Paths
 */

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int result = solution.uniquePaths(7, 3);
        System.out.println(result);
    }

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i != m - 1 || j != n - 1) {
                    if (i + 1 < m) {
                        grid[i][j] += grid[i + 1][j];
                    }
                    if (j + 1 < n) {
                        grid[i][j] += grid[i][j + 1];
                    }
                }
            }
        }
        return grid[0][0];
    }
}
