package day12;

/**
 * @author Heng Yu
 * @date 3/9/20 4:03 PM
 */


public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray solution = new MaximumProductSubarray();
        int[] nums = new int[]{-4, -3, -2, -1};
        int result = solution.maxProduct(nums);
        System.out.println(result);
    }

    public int maxProduct(int[] nums) {
        int res = nums[nums.length - 1];
        int min = nums[nums.length - 1];
        int max = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; --i) {
            int copyMin = min;
            int copyMax = max;
            min = (Math.min(nums[i], Math.min(nums[i] * copyMin, nums[i] * copyMax)));
            max = (Math.max(nums[i], Math.max(nums[i] * copyMin, nums[i] * copyMax)));
            res = Math.max(res, max);
        }
        return res;
    }
}
