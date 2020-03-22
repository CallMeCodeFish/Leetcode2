package day24;

/**
 * @author Heng Yu
 * @date 3/21/20 7:52 PM
 */

/**
 * leetcode 313: Super Ugly Number
 */

public class SuperUglyNumber {
    public static void main(String[] args) {
        SuperUglyNumber solution = new SuperUglyNumber();
        int[] primes = new int[]{2, 7, 13, 19};
        int result = solution.nthSuperUglyNumber(12, primes);
        System.out.println(result);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        //edge case
        if (n == 1) return 1;

        int len = primes.length;
        int[] indices = new int[len];
        int[] candidates = new int[len];
        for (int i = 0; i < len; ++i) {
            candidates[i] = primes[i];
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int i = 1;
        while (i < n) {
            int minPrimeIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; ++j) {
                if (candidates[j] < min) {
                    minPrimeIndex = j;
                    min = candidates[j];
                }
            }
            if (min != dp[i - 1]) {
                dp[i++] = min;
            }
            ++indices[minPrimeIndex];
            candidates[minPrimeIndex] = primes[minPrimeIndex] * dp[indices[minPrimeIndex]];
        }
        return dp[n - 1];
    }
}
