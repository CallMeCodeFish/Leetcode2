package day2;

/**
 * @author Heng Yu
 * @date 2/27/20 9:59 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 22: Generate Parentheses
 */

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses solution = new GenerateParentheses();
        List<String> result = solution.generateParenthesis(3);
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        //edge case
        if (n <= 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backtrack(0, 0, n, builder, res);
        return res;
    }

    private void backtrack(int lCount, int rCount, int n, StringBuilder builder, List<String> res) {
        //edge case
        if (rCount == n) {
            res.add(builder.toString());
            return;
        }

        if (lCount == rCount) {
            builder.append('(');
            backtrack(lCount + 1, rCount, n, builder, res);
            builder.deleteCharAt(builder.length() - 1);
        } else if (rCount < lCount) {
            if (0 < n - lCount) {
                builder.append('(');
                backtrack(lCount + 1, rCount, n, builder, res);
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append(')');
            backtrack(lCount, rCount + 1, n, builder, res);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
