package day16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/14/20 12:06 AM
 */

/**
 * leetcode 216: Combination Sum III
 */

public class CombinationSumIII {
    public static void main(String[] args) {
        CombinationSumIII solution = new CombinationSumIII();
        List<List<Integer>> result = solution.combinationSum3(4, 24);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        //edge case

        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, k, n, res, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(int start, int k, int n, List<List<Integer>> res, List<Integer> cur, int sum) {
        //edge case
        if (k == 0) {
            if (n == sum) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        for (int i = start; i <= 9; ++i) {
            if (10 - i < k || n < sum + i) break;
            cur.add(i);
            backtrack(i + 1, k - 1, n, res, cur, sum + i);
            cur.remove(cur.size() - 1);
        }
    }
}
