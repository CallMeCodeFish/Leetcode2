package newquestion.day25;

/**
 * @author Heng Yu
 * @date 5/31/20 6:35 PM
 */

import java.util.Arrays;

/**
 * leetcode 698: Partition to k equal sum subsets
 * solution: NP completeness
 */
public class PartitionKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) return false;
        int target = sum / k;

        Arrays.sort(nums);

        if (nums[nums.length - 1] > target) return false;

        int i = nums.length - 1;
        while (i >= 0 && nums[i] == target) {
            i--;
            k--;
        }

        if (k == 0) return true;

        int[] subsets = new int[k];

        return backtracking(nums, i, subsets, target);
    }

    private boolean backtracking(int[] nums, int curIndex, int[] subsets, int target) {
        if (curIndex < 0) return true;

        int cur = nums[curIndex];

        for (int i = 0; i < subsets.length; i++) {
            if (subsets[i] + cur <= target) {
                subsets[i] += cur;

                if (backtracking(nums, curIndex - 1, subsets, target)) return true;

                subsets[i] -= cur;
            }
        }

        return false;
    }
}
