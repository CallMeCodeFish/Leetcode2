package day33;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 4/9/20 5:44 PM
 */

/**
 * leetcode 386: Lexicographical Numbers
 */

public class LexicographicalNumbers {
    public static void main(String[] args) {
        LexicographicalNumbers solution = new LexicographicalNumbers();
        List<Integer> result = solution.lexicalOrder(13);
        System.out.println(result);
    }

    public List<Integer> lexicalOrder(int n) {
        //edge case
        if (n < 1) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            if (i <= n) {
                res.add(i);
                helper(i, n, res);
            } else {
                break;
            }
        }
        return res;
    }

    private void helper(int cur, int n, List<Integer> res) {
        cur *= 10;
        if (cur > n) return;
        res.add(cur);
        helper(cur, n, res);

        for (int i = 1; i < 10; ++i) {
            int num = cur + i;
            if (num <= n) {
                res.add(num);
                helper(num, n, res);
            } else {
                break;
            }
        }
    }
}
