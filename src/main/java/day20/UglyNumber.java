package day20;

/**
 * @author Heng Yu
 * @date 3/17/20 8:30 PM
 */

/**
 * leetcode 263: Ugly Number
 */

public class UglyNumber {
    public static void main(String[] args) {
        UglyNumber solution = new UglyNumber();
        boolean result = solution.isUgly(14);
        System.out.println(result);
    }

    public boolean isUgly(int num) {
        while (0 < num) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                break;
            }
        }
        while (0 < num) {
            if (num % 3 == 0) {
                num /= 3;
            } else {
                break;
            }
        }
        while (0 < num) {
            if (num % 5 == 0) {
                num /= 5;
            } else {
                break;
            }
        }
        return num == 1;
    }
}
