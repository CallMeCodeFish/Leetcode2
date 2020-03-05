package day8;

/**
 * @author Heng Yu
 * @date 3/4/20 7:15 PM
 */

/**
 * leetcode 96: Unique Binary Tree
 */

public class UniqueBST {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 0; j < i; ++j) {
                int k = i - 1 - j;
                dp[i] += dp[j] * dp[k];
            }
        }
        return dp[n];
    }
}
