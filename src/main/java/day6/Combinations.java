package day6;

/**
 * @author Heng Yu
 * @date 3/2/20 6:38 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 77: Combinations
 */

public class Combinations {
    public static void main(String[] args) {
        Combinations solution = new Combinations();
        List<List<Integer>> result = solution.combine(4, 2);
        System.out.println(result);
    }

    public List<List<Integer>> combine(int n, int k) {
        //edge case
        if (n < k) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int start, int end, int k, List<List<Integer>> res, List<Integer> cur) {
        //edge case
        if (end - start + 1 < k - cur.size()) return;
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i <= end; ++i) {
            cur.add(i);
            backtrack(i + 1, end, k, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
