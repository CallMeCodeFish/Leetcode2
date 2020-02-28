package day2;

/**
 * @author Heng Yu
 * @date 2/27/20 8:31 PM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 18: 4Sum
 */

public class FourSum {
    public static void main(String[] args) {
        FourSum solution = new FourSum();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = solution.fourSum(nums, 0);
        System.out.println(result);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        //edge case
        if (nums == null || nums.length < 4)
            return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 3) {
            int j = i + 1;
            while (j < nums.length - 2) {
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        ++l;
                        --r;
                        while (l < r && nums[l - 1] == nums[l] && nums[r] == nums[r + 1]) {
                            ++l;
                            --r;
                        }
                    } else if (sum < target) {
                        ++l;
                        while (l < r && nums[l - 1] == nums[l]) ++l;
                    } else {
                        --r;
                        while (l < r && nums[r] == nums[r + 1]) --r;
                    }
                }
                ++j;
                while (j < nums.length - 2 && nums[j - 1] == nums[j]) ++j;
            }
            ++i;
            while (i < nums.length - 3 && nums[i - 1] == nums[i]) ++i;
        }

        return res;
    }
}
