package day2;

/**
 * @author Heng Yu
 * @date 2/27/20 9:29 PM
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 20: Valid Parentheses
 */

public class ValidParentheses {
    public boolean isValid(String s) {
        //edge case
        if (s == null || s.isEmpty())
            return true;

        char[] chs = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : chs) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                char openBracket = findOpen(ch);
                if (stack.isEmpty() || openBracket != stack.peek()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private char findOpen(char ch) {
        if (ch == ')')
            return '(';
        else if (ch == ']')
            return '[';
        else
            return '{';
    }
}
