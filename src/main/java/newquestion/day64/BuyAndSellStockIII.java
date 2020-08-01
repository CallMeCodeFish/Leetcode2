package newquestion.day64;

/**
 * @author Tim
 * @date 8/1/20 7:01 PM
 */

/**
 * leetcode 123: Best time to buy and sell stock III (hard)
 * solution: dp
 */
public class BuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int len = prices.length;
        int[][] hold = new int[2][len];
        int[][] unhold = new int[2][len];

        for (int i = 1; i < len; i++) {
            hold[0][i] = Math.max(hold[0][i - 1] + prices[i] - prices[i - 1], 0);
            unhold[0][i] = Math.max(unhold[0][i - 1], hold[0][i - 1] + prices[i] - prices[i - 1]);

            hold[1][i] = Math.max(unhold[0][i - 1], hold[1][i - 1] + prices[i] - prices[i - 1]);
            unhold[1][i] = Math.max(unhold[1][i - 1], hold[1][i - 1] + prices[i] - prices[i - 1]);
        }

        return Math.max(unhold[0][len - 1], unhold[1][len - 1]);
    }
}
