package hard;

/**
 * @author Heng Yu
 * @date 5/28/20 4:30 PM
 */

/**
 * leetcode 829: Consecutive numbers sum
 */
public class ConsecutiveSum {
    public int consecutiveNumbersSum(int N) {
        int res = 0;
        int i = 0;
        while (true) {
            double d = (2.0 * N / (i + 1) - i) / 2;
            if (d <= 0) break;

            if (2 * N % (i + 1) == 0 && (2 * N / (i + 1) - i) % 2 == 0) res++;

            i++;
        }

        return res;
    }
}
