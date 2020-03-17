package day19;

/**
 * @author Heng Yu
 * @date 3/16/20 7:20 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 254: Factor Combination
 */

public class FactorCombination {
    public static void main(String[] args) {
        FactorCombination solution = new FactorCombination();
        List<List<Integer>> result = solution.getFactors(36);
        System.out.println(result);
    }

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, 2, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int n, int start, List<List<Integer>> res, List<Integer> list) {
        for (int i = start; i <= n / i; ++i) {
            if (n % i == 0) {
                list.add(i);
                list.add(n / i);
                res.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                backtrack(n / i, i, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
