package newquestion.day56;

/**
 * @author Heng Yu
 * @date 7/18/20 6:03 PM
 */

/**
 * leetcode 233: Number of digit one (hard)
 * solution: e.g. 234
 * 4: 1
 * 34: 3 * (1 * 1) + 10 + 1 = 14
 * 234: 2 * (10 * 2) + 100 + 14 = 154
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;

        int total = 1;
        long mag = 1;
        while (n / (mag * 10) != 0) {
            mag *= 10;
            total++;
        }

        int[] dp = new int[total];
        dp[0] = n % 10 == 0 ? 0 : 1;

        long d = 10;
        for (int i = 1; i < total; i++) {
            int count = (int) d;
            d *= 10;
            int num = (int) (n % d);
            int first = num / count;
            dp[i] += dp[i - 1];
            if (first != 0) {
                dp[i] += first * (count / 10) * i;
                if (first == 1) {
                    dp[i] += num % count + 1;
                } else {
                    dp[i] += count;
                }
            }
        }

        return dp[total - 1];
    }
}
