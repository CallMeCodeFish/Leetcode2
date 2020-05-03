package hard;

/**
 * @author Heng Yu
 * @date 5/2/20 9:35 PM
 */

/**
 * leetcode 410: Split Array Largest Sum
 */
public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[][][] dp = new int[m + 1][len][len];
        for (int i = 1; i < len; ++i) {
            nums[i] += nums[i - 1];
        }

//        helper(dp, m, 0, len - 1, nums);

        return 0;
    }
}
