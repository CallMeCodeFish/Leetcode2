package day10;

/**
 * @author Heng Yu
 * @date 3/6/20 3:50 PM
 */

/**
 * leetcode 121: Best Time to Buy and Sell Stock
 */

public class BestTimeForStock {
    public int maxProfit(int[] prices) {
        int res = 0;
        int i = 0;
        while (i < prices.length) {
            int buy = prices[i];
            int j = i + 1;
            while (j < prices.length) {
                int sell = prices[j];
                if (sell < buy) break;
                int profit = sell - buy;
                res = Math.max(res, profit);
                ++j;
            }
            i = j;
        }
        return res;
    }
}
