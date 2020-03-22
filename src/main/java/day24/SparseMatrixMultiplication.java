package day24;

/**
 * @author Heng Yu
 * @date 3/21/20 7:32 PM
 */

/**
 * leetcode 311: Sparse Matrix Multiplication
 */

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        //edge case
        if (A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0) return new int[1][];
        int m = A.length;
        int n = B[0].length;
        if (A[0].length != B.length) return new int[1][];

        int[][] res = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int k = 0; k < B.length; ++k) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < n; ++j) {
                        res[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return res;
    }
}
