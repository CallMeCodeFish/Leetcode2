package day18;

/**
 * @author Heng Yu
 * @date 3/15/20 7:29 PM
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * leetcode 241: Different Ways to Add Parentheses
 */

public class AddParentheses {
    public static void main(String[] args) {
        AddParentheses solution = new AddParentheses();
        String expr = "2*3-4*5";
        List<Integer> result = solution.diffWaysToCompute(expr);
        System.out.println(result);
    }

    public List<Integer> diffWaysToCompute(String input) {
        char[] chs = input.toCharArray();
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> optrs = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        backtrack(chs, 0, nums, optrs, res);
        return res;
    }

    private void backtrack(char[] chs, int i, Deque<Integer> nums, Deque<Character> optrs, List<Integer> res) {
        //edge case
        if (i == chs.length) {
            Deque<Integer> copyNums = new ArrayDeque<>(nums);
            Deque<Character> copyOptrs = new ArrayDeque<>(optrs);
            while (!copyOptrs.isEmpty()) {
                int second = copyNums.pop();
                int first = copyNums.pop();
                char optr = copyOptrs.pop();
                int value = getValue(first, second, optr);
                copyNums.push(value);
            }
            res.add(copyNums.pop());
            return;
        }

        char ch = chs[i];
        if (Character.isDigit(ch)) {
            StringBuilder sb = new StringBuilder();
            sb.append(ch - '0');
            int j = i + 1;
            while (j < chs.length && Character.isDigit(chs[j])) {
                sb.append(chs[j] - '0');
                ++j;
            }
            int num = Integer.parseInt(sb.toString());
            nums.push(num);
            backtrack(chs, j, nums, optrs, res);
            nums.pop();
            if (!optrs.isEmpty() && j != chs.length) {
                Deque<Integer> copyNums = new ArrayDeque<>(nums);
                copyNums.push(num);
                Deque<Character> copyOptrs = new ArrayDeque<>(optrs);
                while (!copyOptrs.isEmpty()) {
                    int second = copyNums.pop();
                    int first = copyNums.pop();
                    char optr = copyOptrs.pop();
                    int value = getValue(first, second, optr);
                    copyNums.push(value);
                    backtrack(chs, j, copyNums, copyOptrs, res);
                }
            }
        } else {
            optrs.push(ch);
            backtrack(chs, i + 1, nums, optrs, res);;
            optrs.pop();
        }
    }

    private int getValue(int first, int second, char optr) {
        int res = 0;
        if (optr == '+') {
            res = first + second;
        } else if (optr == '-') {
            res = first - second;
        } else {
            res = first * second;
        }
        return res;
    }
}
