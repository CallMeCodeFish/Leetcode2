package day32;

/**
 * @author Heng Yu
 * @date 4/8/20 4:48 PM
 */

/**
 * leetcode 374: Guess Number Higher or Lower
 */

public class GuessNumber {
    public static void main(String[] args) {
        GuessNumber solution = new GuessNumber();
        int result = solution.guessNumber(10);
        System.out.println(result);
    }

    private int target = 6;

    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int result = guess(mid);
            if (result == 0) {
                return mid;
            } else if (result < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int guess(int num) {
        if (num < target) return 1;
        else if (num > target) return -1;
        return 0;
    }
}
