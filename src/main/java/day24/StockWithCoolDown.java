package day24;

/**
 * @author Heng Yu
 * @date 3/21/20 5:39 PM
 */

/**
 * leetcode 309: Best Time to Buy and Sell Stock with Cool Down
 */

public class StockWithCoolDown {
    public static void main(String[] args) {
        StockWithCoolDown solution = new StockWithCoolDown();
        int[] prices = new int[]{1, 2, 3, 0, 2};
        int result = solution.maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int len = prices.length;
        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0], Math.max(dp[len - 1][1], dp[len - 1][2]));
    }
}
