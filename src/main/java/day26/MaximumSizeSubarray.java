package day26;

/**
 * @author Heng Yu
 * @date 3/24/20 9:06 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 325: Maximum Size Subarray Sum Equals k
 */

public class MaximumSizeSubarray {
    public static void main(String[] args) {
        MaximumSizeSubarray solution = new MaximumSizeSubarray();
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int result = solution.maxSubArrayLen(nums, 3);
        System.out.println(result);
    }

    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum == k) {
                res = Math.max(res, i + 1);
            } else {
                if (map.containsKey(sum - k)) {
                    res = Math.max(res, i - map.get(sum - k));
                }
            }
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return res;
    }
}
