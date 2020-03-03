package day6;

/**
 * @author Heng Yu
 * @date 3/2/20 6:51 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 78: Subsets
 */

public class Subsets {
    public static void main(String[] args) {
        Subsets solution = new Subsets();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        //edge case
        if (nums == null || nums.length == 0)
            return res;

        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> cur) {
        for (int i = start; i < nums.length; ++i) {
            cur.add(nums[i]);
            res.add(new ArrayList<>(cur));
            backtrack(nums, i + 1, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
