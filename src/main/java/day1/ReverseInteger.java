package day1;

/**
 * @author Heng Yu
 * @date 2/26/20 8:54 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 7: Reverse Integer
 *
 */

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();
        int result = solution.reverse(120);
        System.out.println(result);
    }

    public int reverse(int x) {
        long value = x;
        if (x < 0)
            value = -value;
        List<Integer> digits = new ArrayList<>();
        long mag = 1;
        while (value != 0) {
            digits.add((int) (value % 10));
            value /= 10;
            mag *= 10;
        }
        mag /= 10;
        long res = 0;
        for (int digit : digits) {
            res += digit * mag;
            mag /= 10;
        }
        if (x < 0)
            res = -res;
        if (Integer.MAX_VALUE < res || res < Integer.MIN_VALUE)
            return 0;
        return (int) res;
    }
}
