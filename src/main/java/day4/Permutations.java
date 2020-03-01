package day4;

/**
 * @author Heng Yu
 * @date 2/29/20 5:14 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 46: Permutations
 */

public class Permutations {
    public static void main(String[] args) {
        Permutations solution = new Permutations();
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
    }

    public List<List<Integer>> permute(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0)   return new ArrayList<>();

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

        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                cur.add(nums[i]);
                backtrack(nums, visited, res, cur);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }
}
