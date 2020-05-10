package hard;

/**
 * @author Heng Yu
 * @date 5/9/20 6:05 PM
 */

/**
 * leetcode 85: Maximal rectangle
 */
public class MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {
        //edge case
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int res = 0;
        int[][] rows = new int[m][n];
        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == '1') {
                rows[i][0] = 1;
                res = Math.max(res, rows[i][0]);
            }
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    rows[i][j] = rows[i][j - 1] + 1;
                    res = Math.max(res, rows[i][j]);
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    int minWidth = rows[i][j];
                    int k = i - 1;
                    while (k >= 0) {
                        if (matrix[k][j] == '0') break;
                        minWidth = Math.min(minWidth, rows[k][j]);
                        res = Math.max(res, minWidth * (i - k + 1));
                        --k;
                    }
                }
            }
        }

        return res;
    }
}
