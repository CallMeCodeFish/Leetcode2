package newquestion.day30;

/**
 * @author Heng Yu
 * @date 6/5/20 5:03 PM
 */

import java.util.Arrays;

/**
 * leetcode 887: Super egg drop
 * ref: https://www.cnblogs.com/Phantom01/p/9490508.html
 */
public class SuperEggDrop {
    public static void main(String[] args) {
        SuperEggDrop solution = new SuperEggDrop();
        int result = solution.superEggDrop(2, 2);
        System.out.println(result);
    }

    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            ++m;
            for (int k = 1; k <= K; ++k)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;
    }

    public int superEggDrop1(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];

        for (int i = 0; i < K + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int j = 0; j < N + 1; j++) {
            dp[0][j] = 0;
            dp[1][j] = j;
        }

        for (int i = 0; i < K + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 2; i < K + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int l = 1, h = j;
                while (l <= h) {
                    int mid = l + (h - l) / 2;
                    int b = dp[i - 1][mid - 1];
                    int nb = dp[i][j - mid];
                    if (b > nb) {
                        h = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                    int cur = Math.max(b, nb) + 1;
                    dp[i][j] = Math.min(dp[i][j], cur);
                }
//                for (int k = 1; k <= j; k++) {
//                    int cur = Math.max(dp[i - 1][k - 1], dp[i][j - k]) + 1;
//                    dp[i][j] = Math.min(dp[i][j], cur);
//                }

            }
        }

        return dp[K][N];
    }
}
