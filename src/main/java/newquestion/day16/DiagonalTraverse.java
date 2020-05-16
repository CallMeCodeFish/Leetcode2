package newquestion.day16;

/**
 * @author Heng Yu
 * @date 5/15/20 3:50 PM
 */

import java.util.Arrays;

/**
 * leetcode 498: Diagonal traverse
 */
public class DiagonalTraverse {
    public static void main(String[] args) {
        DiagonalTraverse solution = new DiagonalTraverse();
        int[][] matrix = {{2,3}};
        int[] result = solution.findDiagonalOrder(matrix);
        System.out.println(Arrays.toString(result));
    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;
        int len = m * n;

        int[] res = new int[len];

        int k = 0;

        for (int s = 0; s <= m + n - 2; ++s) {
            if (s % 2 == 0) { // left to right
                if (s < m) {
                    int i = s;
                    while (i >= 0 && s - i < n) {
                        int j = s - i;
                        res[k++] = matrix[i][j];
                        --i;
                    }
                } else {
                    int i = m - 1;
                    while (s - i < n && i >= 0) {
                        int j = s - i;
                        res[k++] = matrix[i][j];
                        --i;
                    }
                }
            } else { // right to left
                if (s < n) {
                    int j = s;
                    while (j >= 0 && s - j < m) {
                        int i = s - j;
                        res[k++] = matrix[i][j];
                        --j;
                    }
                } else {
                    int j = n - 1;
                    while (s - j < m && j >= 0) {
                        int i = s - j;
                        res[k++] = matrix[i][j];
                        --j;
                    }
                }
            }
        }

        return res;
    }
}
