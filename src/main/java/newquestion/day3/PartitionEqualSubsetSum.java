package newquestion.day3;

/**
 * @author Heng Yu
 * @date 4/26/20 7:59 PM
 */

/**
 * leetcode 416: Partition Equal Subset Sum
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;

        int m = nums.length + 1;
        int n = 1 + sum / 2;
        boolean[][] dp = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            dp[i][0] = true;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (dp[i - 1][j] || j - nums[i - 1] >= 0 && dp[i - 1][j - nums[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
