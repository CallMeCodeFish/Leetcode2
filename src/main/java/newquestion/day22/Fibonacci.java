package newquestion.day22;

/**
 * @author Heng Yu
 * @date 5/26/20 5:40 PM
 */

/**
 * leetcode 509: Fibonacci number
 */
public class Fibonacci {
    public int fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;

        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < dp.length; ++i) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[N];
    }
}
