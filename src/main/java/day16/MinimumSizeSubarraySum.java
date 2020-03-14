package day16;

/**
 * @author Heng Yu
 * @date 3/13/20 9:29 PM
 */

/**
 * leetcode 209: Minimum Size Subarray Sum
 */

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum solution = new MinimumSizeSubarraySum();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int result = solution.minSubArrayLen(7, nums);
        System.out.println(result);
    }

    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        boolean canFind = false;
        int sum = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (s <= sum) {
                canFind = true;
                res = Math.min(res, j - i + 1);
                sum -= nums[i++];
            }
            ++j;
        }
        if (!canFind) return 0;
        return res;
    }
}
