package day30;

/**
 * @author Heng Yu
 * @date 4/4/20 9:39 PM
 */

/**
 * leetcode 357: Count Numbers with Unique Digits
 */

public class CountNumbers {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] counts = new int[11];
        counts[0] = 1;
        for (int i = 1; i < counts.length; ++i) {
            int count = 9;
            int num = 9;
            int j = i - 1;
            while (0 < j) {
                count *= num--;
                --j;
            }
            counts[i] = count + counts[i - 1];
        }
        if (n > 10) return counts[10];
        return counts[n];
    }
}
