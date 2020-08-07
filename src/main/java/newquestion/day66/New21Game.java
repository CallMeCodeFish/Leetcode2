package newquestion.day66;

/**
 * leetcode 837: New 21 game
 * solution: backward dp
 * ref: https://www.bilibili.com/video/BV1Sz4y197cA?from=search&seid=6882318329191809959
 */
public class New21Game {
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + W];

        for (int i = K; i <= N; i++) {
            dp[i] = 1.0;
        }

        double sum = N - K + 1;

        for (int i = K - 1; i >= 0; i--) {
            dp[i] = sum / W;
            sum += dp[i] - dp[i + W];
        }

        return dp[0];
    }
}
