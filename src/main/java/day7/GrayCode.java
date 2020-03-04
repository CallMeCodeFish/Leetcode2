package day7;

/**
 * @author Heng Yu
 * @date 3/3/20 11:15 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 89: Gray Code
 */

public class GrayCode {
    public static void main(String[] args) {
        GrayCode solution = new GrayCode();
        List<Integer> result = solution.grayCode(2);
        System.out.println(result);
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 1; i <= n; ++i) {
            int size = res.size();
            int digit = 1 << (i - 1);
            for (int j = size - 1; j >= 0; --j) {
                res.add(res.get(j) + digit);
            }
        }
        return res;
    }
}
