package day14;

/**
 * @author Heng Yu
 * @date 3/11/20 5:37 PM
 */

/**
 * leetcode 191: Number of 1 Bits
 */

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int res = 0;
        int i = 0;
        while (i < 32) {
            int digit = n >>> i & 1;
            res += digit;
            ++i;
        }
        return res;
    }
}
