package day9;

/**
 * @author Heng Yu
 * @date 3/6/20 12:07 AM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 118: Pascal's Triangle
 */

public class PascalTriangle {
    public static void main(String[] args) {
        PascalTriangle solution = new PascalTriangle();
        List<List<Integer>> result = solution.generate(5);
        System.out.println(result);
    }

    public List<List<Integer>> generate(int numRows) {
        //edge case
        if (numRows == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; ++i) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if (1 < i) {
                List<Integer> prev = res.get(res.size() - 1);
                for (int j = 1; j < i - 1; ++j) {
                    list.add(prev.get(j - 1) + prev.get(j));
                }
                list.add(1);
            }
            res.add(list);
        }
        return res;
    }
}
