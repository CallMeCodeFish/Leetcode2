package day23;

/**
 * @author Heng Yu
 * @date 3/20/20 5:27 PM
 */

/**
 * leetcode 304: Range Sum Query 2D
 */

public class RangeSumQuery2D {
    private int[][] sums;

    public RangeSumQuery2D(int[][] matrix) {
        if (matrix != null && matrix.length != 0 && matrix[0].length != 0) {
            int m = matrix.length;
            int n = matrix[0].length;
            this.sums = new int[m][n];
            this.sums[0][0] = matrix[0][0];
            for (int i = 1; i < m; ++i) {
                this.sums[i][0] = this.sums[i - 1][0] + matrix[i][0];
            }
            for (int j = 1; j < n; ++j) {
                this.sums[0][j] = this.sums[0][j - 1] + matrix[0][j];
            }
            for (int i = 1; i < m; ++i) {
                for (int j = 1; j < n; ++j) {
                    this.sums[i][j] = this.sums[i - 1][j] + this.sums[i][j - 1] + matrix[i][j] - this.sums[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = sums[row2][col2];
        if (col1 - 1 >= 0) {
            res -= sums[row2][col1 - 1];
        }
        if (row1 - 1 >= 0) {
            res -= sums[row1 - 1][col2];
        }
        if (col1 - 1 >= 0 && row1 - 1 >= 0) {
            res += sums[row1 - 1][col1 - 1];
        }
        return res;
    }
}
