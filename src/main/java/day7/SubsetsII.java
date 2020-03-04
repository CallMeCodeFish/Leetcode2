package day7;

/**
 * @author Heng Yu
 * @date 3/3/20 11:49 PM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 90: Subsets II
 */

public class SubsetsII {
    public static void main(String[] args) {
        SubsetsII solution = new SubsetsII();
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> result = solution.subsetsWithDup(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> cur) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; ++i) {
            cur.add(nums[i]);
            backtrack(nums, i + 1, res, cur);
            cur.remove(cur.size() - 1);
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) ++i;
        }
    }
}
