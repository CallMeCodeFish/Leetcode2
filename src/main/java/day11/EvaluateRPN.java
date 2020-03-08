package day11;

/**
 * @author Heng Yu
 * @date 3/7/20 8:47 PM
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 150: Evaluate Reverse Polish Notation
 */

public class EvaluateRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int second = stack.pop();
                int first = stack.pop();
                int result = calculate(first, second, token);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private int calculate(int n1, int n2, String optr) {
        int res = 0;
        if ("+".equals(optr)) {
            res = n1 + n2;
        } else if ("-".equals(optr)) {
            res = n1 - n2;
        } else if ("*".equals(optr)) {
            res = n1 * n2;
        } else {
            res = n1 / n2;
        }
        return res;
    }

    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }
}
