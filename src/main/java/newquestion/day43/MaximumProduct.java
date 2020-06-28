package newquestion.day43;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 6/27/20 5:30 PM
 */

/**
 * leetcode 628: Maximum product of three numbers
 */
public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int prod1 = nums[nums.length - 1] * nums[nums.length - 2];
        int res = Math.max(prod1 * nums[nums.length - 3], prod1 * nums[0]);

        int prod2 = nums[0] * nums[1];
        res = Math.max(res, Math.max(prod2 * nums[2], prod2 * nums[nums.length - 1]));

        return res;
    }
}
