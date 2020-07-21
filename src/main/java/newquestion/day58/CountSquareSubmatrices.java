package newquestion.day58;

/**
 * @author Heng Yu
 * @date 7/20/20 7:08 PM
 */

/**
 * leetcode 1277: Count square submatrices with all ones
 * solution: dp
 * ref: https://www.bilibili.com/video/BV14J411q7zX?from=search&seid=4759453948579812916
 */
public class CountSquareSubmatrices {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
                res += matrix[i][j];
            }
        }

        return res;
    }

    public int countSquares1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }


        for (int w = 1; w <= n; w++) {
            for (int i = 0; i < n; i++) {
                int j = i + w - 1;
                if (j == n) break;

                int x = 0, y = 0;
                while (y < m) {
                    int count = i == 0 ? matrix[y][j] : matrix[y][j] - matrix[y][i - 1];
                    if (count == w) {
                        y++;
                    } else {
                        int len = y - x;
                        if (len >= w) {
                            res += len - w + 1;
                        }
                        x = ++y;
                    }
                }

                if (x < m) {
                    int len = y - x;
                    if (len >= w) {
                        res += len - w + 1;
                    }
                }
            }
        }

        return res;
    }
}
