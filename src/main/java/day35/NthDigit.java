package day35;

/**
 * @author Heng Yu
 * @date 4/22/20 9:33 PM
 */

/**
 * leetcode 400: Nth Digit
 */
public class NthDigit {
    public static void main(String[] args) {
        NthDigit solution = new NthDigit();
        int result = solution.findNthDigit(1000000000);
        System.out.println(result);
    }

    public int findNthDigit(int n) {
        if (n < 10) return n;
        int cur = 9;
        int digit = 2;
        long count = 90;
        while (n > cur + digit * count) {
            cur += digit * count;
            ++digit;
            count *= 10;
        }
        n -= cur;
        long num = count / 9 + (n - 1) / digit;
        int index = (n - 1) % digit;
        return String.valueOf(num).charAt(index) - '0';
    }
}
