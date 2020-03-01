package day4;

/**
 * @author Heng Yu
 * @date 2/29/20 3:30 PM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 39: Combination Sum
 */

public class CombinationSum {
    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] nums = new int[]{2, 3, 5};
        List<List<Integer>> result = solution.combinationSum(nums, 8);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //edge case
        if (candidates == null || candidates.length == 0)   return new ArrayList<>();

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, int target, List<List<Integer>> res, List<Integer> cur) {
        for (int i = start; i < nums.length; ++i) {
            int nextTarget = target - nums[i];
            if (nextTarget == 0) {
                List<Integer> list = new ArrayList<>(cur);
                list.add(nums[i]);
                res.add(list);
            } else if (0 < nextTarget) {
                cur.add(nums[i]);
                backtrack(nums, i, nextTarget, res, cur);
                cur.remove(cur.size() - 1);
            } else {
                break;
            }
        }
    }
}
