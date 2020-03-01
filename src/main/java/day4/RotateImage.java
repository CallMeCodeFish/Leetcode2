package day4;

/**
 * @author Heng Yu
 * @date 2/29/20 5:49 PM
 */

/**
 * leetcode 48: Rotate Image
 */

public class RotateImage {
    public void rotate(int[][] matrix) {
        //edge case
        if (matrix == null || matrix.length == 0)   return;

        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = i + 1; j < col; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int l = 0;
        int r = col - 1;
        while (l <= r) {
            for (int i = 0; i < row; ++i) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
            }
            ++l;
            --r;
        }
    }
}
