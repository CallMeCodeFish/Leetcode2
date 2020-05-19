package newquestion.day18;

/**
 * @author Heng Yu
 * @date 5/18/20 3:54 PM
 */

/**
 * leetcode 1031: Maximum sum of two non-overlapping subarrays
 */
public class MaximumSum {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int len = A.length;

        //edge case
        if (L + M == len) {
            int res = 0;
            for (int n : A) {
                res += n;
            }
            return res;
        }

        int[] dp = new int[len];
        int cur = 0;
        int i = len - 1, j = len - 1;
        while (i >= 0) {
            cur += A[i];
            if (j - i + 1 == M) {
                if (i == len - 1) {
                    dp[i] = cur;
                } else {
                    dp[i] = Math.max(dp[i + 1], cur);
                }
                cur -= A[j--];
            }
            --i;
        }

        int res = 0;
        i = j = 0;
        cur = 0;

        while (j < len - M) {
            cur += A[j];
            if (j - i + 1 == L) {
                res = Math.max(res, cur + dp[j + 1]);
                cur -= A[i++];
            }
            ++j;
        }

        cur = 0;
        i = j = len - 1;
        while (i >= 0) {
            cur += A[i];
            if (j - i + 1 == L) {
                if (i == len - 1) {
                    dp[i] = cur;
                } else {
                    dp[i] = Math.max(dp[i + 1], cur);
                }
                cur -= A[j--];
            }
            --i;
        }

        i = j = 0;
        cur = 0;
        while (j < len - L) {
            cur += A[j];
            if (j - i + 1 == M) {
                res = Math.max(res, cur + dp[j + 1]);
                cur -= A[i++];
            }
            ++j;
        }

        return res;
    }
}
