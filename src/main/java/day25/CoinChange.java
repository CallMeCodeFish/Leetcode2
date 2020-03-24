package day25;

/**
 * @author Heng Yu
 * @date 3/23/20 9:55 PM
 */

import java.util.Arrays;

/**
 * leetcode 322: Coin Change
 */

public class CoinChange {
    public static void main(String[] args) {
        CoinChange solution = new CoinChange();
        int[] coins = new int[]{186,419,83,408};
        int result = solution.coinChange(coins, 6249);
        System.out.println(result);
    }

    public int coinChange(int[] coins, int amount) {
        //edge case
        if (coins == null || coins.length == 0) return 0;

        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin == i) {
                    dp[i] = 1;
                    break;
                } else if (coin < i) {
                    if (dp[i - coin] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                    }
                } else {
                    break;
                }
            }
        }
        return (dp[amount] == Integer.MAX_VALUE)? -1 : dp[amount];
    }
}
