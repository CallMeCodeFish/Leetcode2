package day10;

/**
 * @author Heng Yu
 * @date 3/6/20 4:00 PM
 */

/**
 * leetcode 122: Best Time to Buy and Sell Stock
 */

public class BestTimeForStockII {
    public static void main(String[] args) {
        BestTimeForStockII solution = new BestTimeForStockII();
        int[] prices = new int[]{1,2,3,4,5};
        int result = solution.maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int i = 0;
        while (i < prices.length) {
            int buy = prices[i];
            int j = i + 1;
            int max = 0;
            while (j < prices.length) {
                int sell = prices[j];
                if (sell < prices[j - 1]) break;
                int profit = sell - buy;
                max = Math.max(max, profit);
                ++j;
            }
            res += max;
            i = j;
        }
        return res;
    }
}
