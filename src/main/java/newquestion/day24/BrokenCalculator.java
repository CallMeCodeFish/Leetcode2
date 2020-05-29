package newquestion.day24;

/**
 * @author Heng Yu
 * @date 5/28/20 3:42 PM
 */

/**
 * leetcode 991: Broken calculator
 */
public class BrokenCalculator {
    public int brokenCalc(int x, int y) {
        if (y <= x) return x - y;

        int res = 0;
        while (x < y) {
            if (y % 2 == 1) {
                y++;
            } else {
                y >>= 1;
            }
            res++;
        }

        res += x - y;

        return res;
    }
}
