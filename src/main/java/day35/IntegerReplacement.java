package day35;

/**
 * @author Heng Yu
 * @date 4/22/20 6:07 PM
 */

/**
 * leetcode 397: Integer Replacement
 */
public class IntegerReplacement {
    public static void main(String[] args) {
        IntegerReplacement solution = new IntegerReplacement();
        int result = solution.integerReplacement(Integer.MAX_VALUE);
        System.out.println(result);
    }

    public int integerReplacement(int n) {
        int res = 0;
        long x = n;
        while (x > 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                if (x % 4 == 1 || x == 3) {
                    --x;
                } else {
                    ++x;
                }
            }
            ++res;
        }
        return res;
    }
}
