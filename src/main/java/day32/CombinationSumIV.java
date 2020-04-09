package day32;

/**
 * @author Heng Yu
 * @date 4/8/20 6:34 PM
 */

import java.util.Arrays;

/**
 * leetcode 377: Combination Sum IV
 */

public class CombinationSumIV {
    public static void main(String[] args) {
        CombinationSumIV solution = new CombinationSumIV();
        int[] nums = {1, 2, 3};
        int result = solution.combinationSum4(nums, 4);
        System.out.println(result);
    }

    public int combinationSum4(int[] nums, int target) {
        //edge case
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return backtrack(nums, target, memo);
    }

    private int backtrack(int[] nums, int target, int[] memo) {
        if (memo[target] != -1) return memo[target];

        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (target == nums[i]) {
                ++res;
            } else if (nums[i] < target) {
                res += backtrack(nums, target - nums[i], memo);
            } else {
                break;
            }
        }
        memo[target] = res;
        return res;
    }
}
