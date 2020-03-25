package day26;

/**
 * @author Heng Yu
 * @date 3/24/20 10:01 PM
 */

/**
 * leetcode 326: Power of Three
 */

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return n == 1;
    }
}
