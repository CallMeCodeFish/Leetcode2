package day27;

/**
 * @author Heng Yu
 * @date 3/27/20 9:29 PM
 */

/**
 * leetcode 342: Power of Four
 */

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        //edge case
        if (num <= 0) return false;

        while (num > 0) {
            if (num == 1) return true;
            if (num % 4 != 0) return false;
            num /= 4;
        }
        return false;
    }
}
