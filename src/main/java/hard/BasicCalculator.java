package hard;

/**
 * @author Heng Yu
 * @date 5/12/20 4:59 PM
 */

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 224: Basic calculator
 */
public class BasicCalculator {
    public int calculate(String s) {
        char[] chs = s.toCharArray();
        Deque<Integer> nums = new LinkedList<>();
        Deque<Character> ops = new LinkedList<>();

        int i = 0;
        while (i < chs.length) {
            if (Character.isDigit(chs[i])) {
                StringBuilder sb = new StringBuilder();
                while (i < chs.length && Character.isDigit(chs[i])) {
                    sb.append(chs[i++]);
                }
                int num = Integer.parseInt(sb.toString());
                if (!ops.isEmpty() && !ops.peek().equals('(')) {
                    char op = ops.pop();
                    int prev = nums.pop();
                    num = (op == '+') ? prev + num : prev - num;
                }
                nums.push(num);
            } else if (chs[i] == '+' || chs[i] == '-' || chs[i] == '('){
                ops.push(chs[i]);
                ++i;
            } else if (chs[i] == ')') {
                while (!ops.peek().equals('(')) {
                    int second = nums.pop();
                    int first = nums.pop();
                    ops.pop();
                    int next = first + second;
                    nums.push(next);
                }
                ops.pop();
                if (!ops.isEmpty() && !ops.peek().equals('(')) {
                    int second = nums.pop();
                    int first = nums.pop();
                    char op = ops.pop();
                    int num = (op == '+')? first + second : first - second;
                    nums.push(num);
                }
                ++i;
            } else {
                ++i;
            }
        }

        return nums.pop();
    }
}
