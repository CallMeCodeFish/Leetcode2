package day23;

/**
 * @author Heng Yu
 * @date 3/20/20 4:20 PM
 */


public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        int result = solution.lengthOfLIS(nums);
        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; ++i) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; --j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
