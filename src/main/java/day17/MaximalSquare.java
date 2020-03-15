package day17;

/**
 * @author Heng Yu
 * @date 3/14/20 5:23 PM
 */

/**
 * leetcode 221: Maximal Square
 */

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        //edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                res = Math.max(res, dfs(matrix, i, j, i, j));
            }
        }
        return res;
    }

    private int dfs(char[][] matrix, int lx, int ly, int rx, int ry) {
        //edge case
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == rx || n == ry) return 0;

        for (int i = ly; i <= ry; ++i) {
            if (matrix[rx][i] == '0') return 0;
        }
        for (int i = lx; i <= rx; ++i) {
            if (matrix[i][ry] == '0') return 0;
        }
        int len = rx - lx + 1;
        int res = len * len;
        res = Math.max(res, dfs(matrix, lx, ly, rx + 1, ry + 1));
        return res;
    }
}
