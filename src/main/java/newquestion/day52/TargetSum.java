package newquestion.day52;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 7/11/20 5:30 PM
 */

/**
 * leetcode 494: Target sum
 */
public class TargetSum {
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        int[][] memo = new int[len][2001];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }

        return helper(nums, 0, 0, S, memo);
    }

    private int helper(int[] nums, int i, int cur, int target, int[][] memo) {
        if (i == nums.length) {
            return cur == target ? 1 : 0;
        }

        int j = cur + 1000;
        if (memo[i][j] != -1) return memo[i][j];

        int res = 0;

        res += helper(nums, i + 1, cur + nums[i], target, memo);
        res += helper(nums, i + 1, cur - nums[i], target, memo);

        memo[i][j] = res;
        return res;
    }
}
