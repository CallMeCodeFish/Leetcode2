package newquestion.day54;

/**
 * @author Heng Yu
 * @date 7/13/20 5:36 PM
 */

/**
 * leetcode 1004: Max consecutive ones III
 * solution: sliding window
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int res = 0;

        int count = 0;
        int i = 0, j = 0;
        int len = A.length;

        while (j < len) {
            if (A[j] == 0) count++;

            while (count > K) {
                if (A[i] == 0) count--;
                i++;
            }

            res = Math.max(res, j - i + 1);

            j++;
        }

        return res;
    }
}
