package newquestion.day68;


/**
 * leetcode 1314: Matrix block sum
 */
public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] res = new int[m][n];

        int[][] h = new int[m][n]; //accumulative sum in row
        int[][] v = new int[m][n]; //accumulative sum in column

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) v[i][j] = mat[i][j];
                else v[i][j] += v[i - 1][j] + mat[i][j];
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (j == 0) h[i][j] = mat[i][j];
                else h[i][j] += h[i][j - 1] + mat[i][j];
            }
        }

        int sum = 0;
        for (int i = 0; i <= K; i++) {
            sum += h[i][Math.min(n - 1, K)];
        }

        for (int i = 0; i < m; i++) {
            int cur = sum;
            for (int j = 0; j < n; j++) {
                res[i][j] = cur;
                if (j - K >= 0) {
                    cur -= v[Math.min(i + K, m - 1)][j - K];
                    if (i - K - 1 >= 0) {
                        cur += v[i - K - 1][j - K];
                    }
                }
                if (j + K + 1 < n) {
                    cur += v[Math.min(i + K, m - 1)][j + K + 1];
                    if (i - K - 1>= 0) {
                        cur -= v[i - K - 1][j + K + 1];
                    }
                }
            }
            if (i - K >= 0) {
                sum -= h[i - K][Math.min(n - 1, K)];
            }
            if (i + K + 1 < m) {
                sum += h[i + K + 1][Math.min(n - 1, K)];
            }
        }


        return res;
    }
}
