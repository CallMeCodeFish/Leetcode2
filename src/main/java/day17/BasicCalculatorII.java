package day17;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heng Yu
 * @date 3/14/20 6:54 PM
 */


public class BasicCalculatorII {
    public int calculate(String s) {
        char[] expr = s.toCharArray();
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> optrs = new ArrayDeque<>();
        int i = 0;
        while (i < expr.length) {
            char ch = expr[i];
            if (ch == ' ') {
                ++i;
            } else if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                int j = i;
                while (j < expr.length && Character.isDigit(expr[j])) {
                    sb.append(expr[j]);
                    ++j;
                }
                int num = Integer.parseInt(sb.toString());
                if (!optrs.isEmpty()) {
                    if (optrs.peek() == '*' || optrs.peek() == '/') {
                        int first = nums.pop();
                        char optr = optrs.pop();
                        num = getValue(first, num, optr);
                    } else if (optrs.peek() == '-') {
                        optrs.pop();
                        num = -num;
                        optrs.push('+');
                    }
                }
                nums.push(num);
                i = j;
            } else {
                optrs.push(ch);
                ++i;
            }
        }
        while (!optrs.isEmpty()) {
            int second = nums.pop();
            int first = nums.pop();
            char optr = optrs.pop();
            nums.push(getValue(first, second, optr));
        }
        return nums.pop();
    }

    private int getValue(int first, int second, char optr) {
        int res = 0;
        if (optr == '+') {
            res = first + second;
        } else if (optr == '-') {
            res = first - second;
        } else if (optr == '*') {
            res = first * second;
        } else {
            res = first / second;
        }
        return res;
    }
}
