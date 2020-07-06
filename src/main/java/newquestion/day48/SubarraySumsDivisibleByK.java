package newquestion.day48;

/**
 * @author Heng Yu
 * @date 7/5/20 4:16 PM
 */

/**
 * leetcode 974: Subarray sums divisible by k
 * solution: prefix
 */
public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] A, int K) {
        int[] counts = new int[K];
        counts[0] = 1;

        int sum = 0;
        int res = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int remain = sum % K;
            if (remain < 0) remain += K;
            res += counts[remain]++;
        }

        return res;
    }
}
