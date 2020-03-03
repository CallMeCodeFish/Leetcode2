package day6;

/**
 * @author Heng Yu
 * @date 3/2/20 3:45 PM
 */

/**
 * leetcode 69: Sqrt(x)
 */

public class SquareRoot {
    public static void main(String[] args) {
        SquareRoot solution = new SquareRoot();
        int result = solution.mySqrt(9);
        System.out.println(result);
    }

    public int mySqrt(int x) {
        long min = 1;
        long max = x;
        while (min <= max) {
            long mid = min + (max - min) / 2;
            long square = mid * mid;
            if (x == square) {
                return (int) mid;
            } else if (x < square) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return (int) (min - 1);
    }
}
