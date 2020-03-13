package day15;

/**
 * @author Heng Yu
 * @date 3/12/20 11:11 PM
 */

import java.util.Arrays;

/**
 * leetcode 204: Count Primes
 */

public class CountPrimes {
    public static void main(String[] args) {
        CountPrimes solution = new CountPrimes();
        int result = solution.countPrimes(2);
        System.out.println(result);
    }

    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i <= n - 1; ++i) {
            if (primes[i]) {
                if (i <= (n - 1) / i) {
                    int j = i;
                    while (j <= (n - 1) / i) {
                        primes[i * j] = false;
                        ++j;
                    }
                } else {
                    break;
                }
            }
        }
        int res = 0;
        for (int i = 2; i < n; ++i) {
            if (primes[i]) ++res;
        }
        return res;
    }
}
