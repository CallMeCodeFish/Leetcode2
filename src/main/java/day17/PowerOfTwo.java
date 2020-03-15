package day17;

/**
 * @author Heng Yu
 * @date 3/14/20 9:57 PM
 */

/**
 * leetcode 231: Power of Two
 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (1 < n) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }
}
