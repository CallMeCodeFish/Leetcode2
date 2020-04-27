package newquestion.day3;

/**
 * @author Heng Yu
 * @date 4/26/20 8:33 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 417: Pacific Atlantic water flow
 */
public class WaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        //edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] p = new boolean[m][n];
        boolean[][] a = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            p[i][0] = true;
            a[i][n - 1] = true;
        }
        for (int i = 0; i < n; ++i) {
            p[0][i] = true;
            a[m - 1][i] = true;
        }

        for (int i = 0; i < n; ++i) {
            helper(matrix, p, 0, i);
            helper(matrix, a, m - 1, i);
        }

        for (int i = 0; i < m; ++i) {
            helper(matrix, p, i, 0);
            helper(matrix, a, i, n - 1);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (p[i][j] && a[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }

        return res;
    }

    private void helper(int[][] matrix, boolean[][] dp, int i, int j) {
        int m = dp.length;
        int n = dp[0].length;

        if (i - 1 >= 0 && !dp[i - 1][j] && matrix[i - 1][j] >= matrix[i][j]) {
            dp[i - 1][j] = true;
            helper(matrix, dp, i - 1, j);
        }

        if (i + 1 < m && !dp[i + 1][j] && matrix[i + 1][j] >= matrix[i][j]) {
            dp[i + 1][j] = true;
            helper(matrix, dp, i + 1, j);
        }

        if (j - 1 >= 0 && !dp[i][j - 1] && matrix[i][j - 1] >= matrix[i][j]) {
            dp[i][j - 1] = true;
            helper(matrix, dp, i, j - 1);
        }

        if (j + 1 < n && !dp[i][j + 1] && matrix[i][j + 1] >= matrix[i][j]) {
            dp[i][j + 1] = true;
            helper(matrix, dp, i, j + 1);
        }
    }
}
