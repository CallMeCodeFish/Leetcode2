package day32;

/**
 * @author Heng Yu
 * @date 4/8/20 4:54 PM
 */

import java.util.Arrays;

/**
 * leetcode 375: Guess Number Higher or Lower II
 */

public class GuessNumberII {
    public static void main(String[] args) {
        GuessNumberII solution = new GuessNumberII();
        int result = solution.getMoneyAmount(30);
        System.out.println(result);
    }

    public int getMoneyAmount(int n) {
        //edge case
        if (n == 1) return 0;

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < dp.length; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        return helper(1, n, dp);
    }

    private int helper(int l, int r, int[][] dp) {
        //edge case
        if (l >= r) return 0;

        if (dp[l][r] != Integer.MAX_VALUE) return dp[l][r];

        for (int i = l; i <= r; ++i) {
            int cur = i;
            int left = helper(l, i - 1, dp);
            int right = helper(i + 1, r, dp);
            cur += Math.max(left, right);
            dp[l][r] = Math.min(dp[l][r], cur);
        }
        return dp[l][r];
    }
}
