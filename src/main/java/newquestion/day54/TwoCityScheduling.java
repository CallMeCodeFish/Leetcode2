package newquestion.day54;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 7/13/20 7:14 PM
 */

/**
 * leetcode 1029: two city scheduling
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> a[0] - a[1] - (b[0] - b[1]));
        int res = 0;
        int n = costs.length / 2;

        for (int i = 0; i < n; i++) {
            res += costs[i][0] + costs[i + n][1];
        }

        return res;
    }
}
