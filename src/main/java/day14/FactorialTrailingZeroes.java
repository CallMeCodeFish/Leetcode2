package day14;

/**
 * @author Heng Yu
 * @date 3/11/20 2:44 PM
 */

/**
 * leetcode 172: Factorial Trailing Zeroes
 */

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        while (0 < n) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
