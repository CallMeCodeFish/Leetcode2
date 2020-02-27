package day1;

/**
 * @author Heng Yu
 * @date 2/26/20 9:34 PM
 */

/**
 * leetcode 8:  String to Integer (atoi)
 *
 */

public class StringToInteger {
    public static void main(String[] args) {
        StringToInteger solution = new StringToInteger();
        int result = solution.myAtoi("9223372036854775808");
        System.out.println(result);
    }

    public int myAtoi(String str) {
        if (str == null || str.isEmpty())
            return 0;

        long res = 0;
        int sign = 1;
        char[] chs = str.toCharArray();
        boolean isFound = false;
        for (char ch : chs) {
            if (!isFound) {
                if (' ' == ch) {
                    continue;
                } else if (Character.isDigit(ch) || '+' == ch || '-' == ch) {
                    isFound = true;
                    if ('-' == ch) {
                        sign = -1;
                    } else if (Character.isDigit(ch)) {
                        res *= 10;
                        res += ch - '0';
                        if (Integer.MAX_VALUE < sign * res) return Integer.MAX_VALUE;
                        if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
            } else {
                if (!Character.isDigit(ch)) {
                    break;
                }
                res *= 10;
                res += ch - '0';
                if (Integer.MAX_VALUE < sign * res) return Integer.MAX_VALUE;
                if (sign * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }
        }
        res *= sign;
        return (int) res;
    }
}
