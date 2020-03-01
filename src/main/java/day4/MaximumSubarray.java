package day4;

/**
 * @author Heng Yu
 * @date 2/29/20 8:10 PM
 */

/**
 * leetcode 53: Maximum Subarray
 */

/**
 * follow up: using divide and conquer (https://blog.csdn.net/qq_40774175/article/details/82319951)
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = solution.maxSubArray(nums);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return 0;

        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            res = Math.max(res, sum);
        }
        return res;
    }
}
