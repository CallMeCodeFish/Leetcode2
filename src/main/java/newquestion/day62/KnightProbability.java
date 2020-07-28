package newquestion.day62;

/**
 * @author Heng Yu
 * @date 7/27/20 5:27 PM
 */

/**
 * leetcode 688: Knight probability in chessboard
 * solution: 3D dp
 */
public class KnightProbability {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dirs = {{-2, 1},{-2, -1},{2, 1},{2, -1},{1, -2},{-1, -2},{1, 2},{-1, 2}};
        double[][][] dp = new double[N][N][K + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if (ni < 0 || ni >= N || nj < 0 || nj >= N) {
                        dp[i][j][1] += 0.125;
                    }
                }
            }
        }

        for (int k = 2; k <= K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] d : dirs) {
                        int ni = i + d[0];
                        int nj = j + d[1];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                            dp[i][j][k] += dp[ni][nj][k - 1];
                        }
                    }
                    dp[i][j][k] *= 0.125;
                }
            }
        }

        double res = 0;

        for (int k = 1; k <= K; k++) {
            res += dp[r][c][k];
        }

        return 1 - res;
    }
}
