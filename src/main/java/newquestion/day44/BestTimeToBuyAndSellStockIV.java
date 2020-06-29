package newquestion.day44;

/**
 * @author Heng Yu
 * @date 6/28/20 11:59 PM
 */

/**
 * leetcode 188: Best time to buy and sell stock IV (hard)
 * ref: https://www.bilibili.com/video/BV15E411f7DR?from=search&seid=15615403893210032406
 */
public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int res = 0;

        if (k >= len / 2) {
            for (int i = 1; i < len; i++) {
                int profit = prices[i] - prices[i - 1];
                if (profit > 0) res += profit;
            }
            return res;
        }

        int[][] dp = new int[k + 1][2];

        for (int i = 1; i <= len; i++) {
            for (int j = k; j >= 1; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1]);
                int profit = i == 1 ? 0 : prices[i - 1] - prices[i - 2];
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0]) + profit;
                res = Math.max(res, Math.max(dp[j][0], dp[j][1]));
            }
        }

        return res;
    }
}
