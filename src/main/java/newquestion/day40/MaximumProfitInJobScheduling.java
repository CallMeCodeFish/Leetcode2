package newquestion.day40;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 6/21/20 10:28 PM
 */

/**
 * leetcode 1235: Maximum profit in job scheduling
 * ref: https://www.youtube.com/watch?v=cr6Ip0J9izc  and  https://www.youtube.com/watch?v=omnSO-CSFIs
 */
public class MaximumProfitInJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;

        int[][] jobs = new int[len][];

        for (int i = 0; i < len; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        int[] dp = new int[len];
        dp[0] = jobs[0][2];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], jobs[i][2]);
            for (int j = i - 1; j >= 0; j--) {
                if (jobs[j][1] <= jobs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i][2]);
                    break;
                }
            }
        }

        return dp[len - 1];
    }
}
