package day2;

/**
 * @author Heng Yu
 * @date 2/27/20 5:18 PM
 */

import java.util.*;

/**
 * leetcode 15: 3Sum
 */

public class ThreeSum {
    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        int[] nums = new int[]{-2, 0, 0, 2, 2};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        //edge case
        if (nums == null || nums.length < 3)
            return new ArrayList<>();


        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int k = 0;
        while (k < nums.length - 2) {
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    res.add(list);
                    ++i;
                    --j;
                    while (i < j && nums[i - 1] == nums[i] && nums[j] == nums[j + 1]) {
                        ++i;
                        --j;
                    }
                } else if (sum < 0) {
                    ++i;
                    while (i < j && nums[i - 1] == nums[i]) ++i;
                } else {
                    --j;
                    while (i < j && nums[j] == nums[j + 1]) --j;
                }
            }
            ++k;
            while (k < nums.length - 2 && nums[k - 1] == nums[k]) ++k;
        }
        return res;
    }
}
