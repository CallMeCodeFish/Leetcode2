package day28;

/**
 * @author Heng Yu
 * @date 3/28/20 7:10 PM
 */

/**
 * leetcode 343: Integer Break
 */

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int l = 1;
            int r = i - 1;
            while (l <= r) {
                dp[i] = Math.max(dp[i], Math.max(l, dp[l]) * Math.max(r, dp[r]));
                ++l;
                --r;
            }
        }
        return dp[n];
    }
}
