package day31;

/**
 * @author Heng Yu
 * @date 4/7/20 8:09 PM
 */

/**
 * leetcode 367: Valid Perfect Square
 */

public class ValidPerfectSquare {
    public static void main(String[] args) {
        ValidPerfectSquare solution = new ValidPerfectSquare();
        boolean result = solution.isPerfectSquare(Integer.MAX_VALUE);
        System.out.println(result);
    }

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int q = num / mid;
            if (mid == q) {
                return num % mid == 0;
            } else if (mid < q) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
