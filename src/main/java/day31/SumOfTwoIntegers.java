package day31;

/**
 * @author Heng Yu
 * @date 4/7/20 9:56 PM
 */

/**
 * leetcode 371: Sum of Two Integers
 */

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        SumOfTwoIntegers solution = new SumOfTwoIntegers();
        int result = solution.getSum(-2, 3);
        System.out.println(result);
    }

    public int getSum(int a, int b) {
        int res = 0;
        int carry = 0;
        for (int i = 0; i < 32; ++i) {
            int d1 = a >>> i & 1;
            int d2 = b >>> i & 1;
            int digit = 0;
            if (carry == 1) {
                if (d1 == 1 && d2 == 1) {
                    digit = 1;
                    carry = 1;
                } else if (d1 == 1 || d2 == 1) {
                    digit = 0;
                    carry = 1;
                } else {
                    digit = 1;
                    carry = 0;
                }
            } else {
                if (d1 == 1 && d2 == 1) {
                    digit = 0;
                    carry = 1;
                } else if (d1 == 1 || d2 == 1) {
                    digit = 1;
                    carry = 0;
                } else {
                    digit = 0;
                    carry = 0;
                }
            }
            if (digit == 1) {
                res |= 1 << i;
            }
        }
        return res;
    }
}
