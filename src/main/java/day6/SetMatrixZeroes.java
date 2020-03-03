package day6;

/**
 * @author Heng Yu
 * @date 3/2/20 5:12 PM
 */

import java.util.Arrays;

/**
 * leetcode 73: Set Matrix Zeroes
 */

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        //edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int m = matrix.length;
        int n = matrix[0].length;
        boolean hasZero = false;
        for (int j = 0; j < n; ++j) {
            if (matrix[0][j] == 0) {
                hasZero = true;
                break;
            }
        }
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < m; ++i) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    break;
                }
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    Arrays.fill(matrix[i], 0);
                    break;
                }
            }
        }
        for (int j = 0; j < n; ++j) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (hasZero) {
            Arrays.fill(matrix[0], 0);
        }
    }
}
