package day6;

/**
 * @author Heng Yu
 * @date 3/2/20 3:18 PM
 */

import java.util.Arrays;

/**
 * leetcode 66: Plus One
 */

public class PlusOne {
    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        int[] digits = new int[]{4, 3, 2, 1};
        int[] result = solution.plusOne(digits);
        System.out.println(Arrays.toString(result));
    }

    public int[] plusOne(int[] digits) {
        int carryBit = 1;
        int i = digits.length - 1;
        while (0 <= i) {
            int sum = digits[i] + carryBit;
            digits[i] = sum % 10;
            carryBit = sum / 10;
            if (carryBit == 0) {
                break;
            }
            --i;
        }
        if (carryBit == 0) return digits;
        int[] res = new int[digits.length + 1];
        res[0] = carryBit;
        i = 0;
        while (i < digits.length) {
            res[i + 1] = digits[i];
            ++i;
        }
        return res;
    }
}
