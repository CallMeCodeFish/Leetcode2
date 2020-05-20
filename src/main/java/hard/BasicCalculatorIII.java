package hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heng Yu
 * @date 5/19/20 5:55 PM
 */

/**
 * leetcode 772: Basic calculator III
 */
public class BasicCalculatorIII {
    public static void main(String[] args) {
        BasicCalculatorIII solution = new BasicCalculatorIII();
        int result = solution.calculate("2*(5+5*2)/3+(6/2+8)");
        System.out.println(result);
    }

    public int calculate(String s) {
        char[] chs = s.toCharArray();
        return helper(chs, s, new int[]{0});
    }

    private int helper(char[] chs, String s, int[] curIndex) { // 1 - (-7)
        Deque<Long> nums = new ArrayDeque<>();
        Deque<Character> opts = new ArrayDeque<>();

        while (curIndex[0] < chs.length) {
            char c = chs[curIndex[0]];
            if (c == ')') {
                ++curIndex[0];
                break;
            }

            if (Character.isDigit(c)) {
                int i = curIndex[0] + 1;
                while (i < chs.length && Character.isDigit(chs[i])) ++i;
                long num = Long.parseLong(s.substring(curIndex[0], i));
                if (!opts.isEmpty() && (opts.peek() == '*' || opts.peek() == '/')) {
                    char opt = opts.pop();
                    long pop = nums.pop();
                    num = doCalculate(pop, num, opt);
                }
                if (!opts.isEmpty() && opts.peek() == '-') {
                    while (!opts.isEmpty() && opts.peek() == '-') {
                        opts.pop();
                        num = -num;
                    }
                    if (nums.isEmpty()) {
                        nums.push(num);
                    } else {
                        nums.push(num);
                        opts.push('+');
                    }
                } else {
                    nums.push(num);
                }
                curIndex[0] = i;
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                opts.push(c);
                ++curIndex[0];
            } else if (c == '(') {
                ++curIndex[0];
                long num = helper(chs, s, curIndex);
                if (!opts.isEmpty() && (opts.peek() == '*' || opts.peek() == '/')) {
                    char opt = opts.pop();
                    long pop = nums.pop();
                    num = doCalculate(pop, num, opt);
                }
                if (!opts.isEmpty() && opts.peek() == '-') {
                    while (!opts.isEmpty() && opts.peek() == '-') {
                        opts.pop();
                        num = -num;
                    }
                    if (nums.isEmpty()) {
                        nums.push(num);
                    } else {
                        nums.push(num);
                        opts.push('+');
                    }
                } else {
                    nums.push(num);
                }
            } else {
                ++curIndex[0];
            }
        }

        while (!opts.isEmpty()) {
            char opt = opts.pop();
            long num2 = nums.pop();
            long num1 = nums.pop();
            long num = doCalculate(num1, num2, opt);
            nums.push(num);
        }

        return nums.pop().intValue();
    }

    private long doCalculate(long num1, long num2, char opt) {
        long res;

        if (opt == '+') {
            res = num1 + num2;
        } else if (opt == '-') {
            res = num1 - num2;
        } else if (opt == '*') {
            res = num1 * num2;
        } else {
            res = num1 / num2;
        }

        return res;
    }
}
