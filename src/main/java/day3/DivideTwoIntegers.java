package day3;

/**
 * @author Heng Yu
 * @date 2/28/20 9:46 PM
 */

/**
 * leetcode 29: Divide Two Integers
 */

public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers solution = new DivideTwoIntegers();
        int result = solution.divide(1, 1);
        System.out.println(result);
    }

    public int divide(int dividend, int divisor) {
        //edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int sign = 1;
        long dd = dividend;
        long dr = divisor;
        if (dd < 0) {
            dd = -dd;
            if (dr < 0) {
                dr = -dr;
            } else {
                sign = -1;
            }
        } else {
            if (dr < 0) {
                sign = -1;
                dr = -dr;
            }
        }
        int res = 0;
        while (dr <= dd) {
            int shift = 0;
            while ((dr << shift) <= dd) {
                ++shift;
            }
            --shift;
            res += 1 << shift;
            dd -= dr << shift;
        }
        if (sign < 0) {
            res = -res;
        }
        return res;
    }
}
