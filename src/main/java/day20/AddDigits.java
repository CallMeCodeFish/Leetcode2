package day20;

/**
 * @author Heng Yu
 * @date 3/17/20 3:45 PM
 */

/**
 * follow up: O(1) time
 * leetcode 258: Add Digits
 */

public class AddDigits {
    public int addDigits(int num) {
        while (0 < num / 10) {
            int sum = 0;
            while (0 < num) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
