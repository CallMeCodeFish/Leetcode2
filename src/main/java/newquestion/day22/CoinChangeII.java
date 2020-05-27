package newquestion.day22;

/**
 * @author Heng Yu
 * @date 5/26/20 6:08 PM
 */

import java.util.Arrays;

/**
 * leetcode 518: Coin change 2
 */
public class CoinChangeII {
    public static void main(String[] args) {
        CoinChangeII solution = new CoinChangeII();
        int[] coins = {1,2,5};
        int result = solution.change(4, coins);
        System.out.println(result);
    }

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public int change1(int amount, int[] coins) {
        Arrays.sort(coins);

        int len = coins.length;
        int[][] dp = new int[amount + 1][len + 1];
        for (int j = 0; j < len + 1; ++j) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < amount + 1; ++i) {
            for (int j = 1; j < len + 1; ++j) {
                int coin = coins[j - 1];
                if (coin <= i) {
                    dp[i][j] = dp[i][j - 1] + dp[i - coin][j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[amount][len];
    }
}
