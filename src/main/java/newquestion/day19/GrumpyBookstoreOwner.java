package newquestion.day19;

/**
 * @author Heng Yu
 * @date 5/19/20 3:41 PM
 */

/**
 * leetcode 1052: Grumpy bookstore owner
 */
public class GrumpyBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int[] memo1 = new int[len];
        int[] memo2 = new int[len];

        int sum = 0;
        for (int i = 0; i < len; ++i) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
            memo1[i] = sum;
        }

        sum = 0;
        int i = 0, j = 0;
        while (j < len) {
            sum += customers[j];
            if (j - i + 1 == X) {
                memo2[i] = sum;
                sum -= customers[i++];
            }
            ++j;
        }

        int res = -1;
        for (int k = 0; k <= len - X; ++k) {
            int cur = memo2[k];
            if (k > 0) cur += memo1[k - 1];
            cur += memo1[len - 1] - memo1[k + X - 1];
            res = Math.max(res, cur);
        }

        return res;
    }
}
