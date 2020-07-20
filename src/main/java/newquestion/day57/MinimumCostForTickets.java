package newquestion.day57;

/**
 * @author Heng Yu
 * @date 7/19/20 5:28 PM
 */

/**
 * leetcode 983: Minimum cost for tickets
 * solution: dp
 */
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int m = days[len - 1];

        int[] dp = new int[m + 1];
        int j = 0;

        for (int i = 1; i <= m; i++) {
            if (i != days[j]) {
                dp[i] = dp[i - 1];
            } else {
                int prev1 = Math.max(0, i - 1);
                int prev2 = Math.max(0, i - 7);
                int prev3 = Math.max(0, i - 30);
                dp[i] = Math.min(dp[prev1] + costs[0], Math.min(dp[prev2] + costs[1], dp[prev3] + costs[2]));
                j++;
            }
        }

        return dp[m];
    }
}
