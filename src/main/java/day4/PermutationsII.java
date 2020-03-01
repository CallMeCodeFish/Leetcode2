package day4;

/**
 * @author Heng Yu
 * @date 2/29/20 5:30 PM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 47: Permutations II
 */

public class PermutationsII {
    public static void main(String[] args) {
        PermutationsII solution = new PermutationsII();
        int[] nums = new int[]{1, 1, 2};
        List<List<Integer>> result = solution.permuteUnique(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0)   return new ArrayList<>();

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, visited, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> cur) {
        //edge case
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        int i = 0;
        while (i < nums.length) {
            if (!visited[i]) {
                visited[i] = true;
                cur.add(nums[i]);
                backtrack(nums, visited, res, cur);
                cur.remove(cur.size() - 1);
                visited[i] = false;
                ++i;
                while (i < nums.length && nums[i - 1] == nums[i]) ++i;
            } else {
                ++i;
            }
        }
    }
}
