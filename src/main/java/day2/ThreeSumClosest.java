package day2;

/**
 * @author Heng Yu
 * @date 2/27/20 6:53 PM
 */

import java.util.Arrays;

/**
 * leetcode 16: 3Sum Closest
 */

public class ThreeSumClosest {
    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        int[] nums = new int[]{1, 1, 1, 0};
        int result = solution.threeSumClosest(nums, -100);
        System.out.println(result);
    }

    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        int k = 0;
        while (k < nums.length - 2) {
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else {
                    int diff = Math.abs(sum - target);
                    if (diff < minDiff) {
                        minDiff = diff;
                        res = sum;
                    }
                    if (sum < target) {
                        ++i;
                        while (i < j && nums[i - 1] == nums[i]) ++i;
                    } else {
                        --j;
                        while (i < j && nums[j] == nums[j + 1]) --j;
                    }
                }
            }
            ++k;
            while (k < nums.length - 2 && nums[k - 1] == nums[k]) ++k;
        }
        return res;
    }
}
