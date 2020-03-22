package contest.mar21;

import java.util.*;

/**
 * @author Heng Yu
 * @date 3/21/20 11:05 PM
 */

/**
 * leetcode 1390: Four Divisors
 */

public class FourDivisors {
    public static void main(String[] args) {
        FourDivisors solution = new FourDivisors();
        int[] nums = new int[]{7286,18704,70773,8224,91675};
        int result = solution.sumFourDivisors(nums);
        System.out.println(result);
    }

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= max; ++i) {
            if (isPrime[i]) {
                int j = i;
                while (i <= max / j) {
                    isPrime[i * j] = false;
                    ++j;
                }
            }
        }
        boolean[] dp = new boolean[max + 1];
        int[] factors = new int[max + 1];
        for (int i = 2; i <= max / 2; ++i) {
            if (isPrime[i]) {
                if (i <= max / i / i) {
                    int num = i * i * i;
                    dp[num] = true;
                    factors[num] = i + i * i;
                }
                for (int j = i + 1; j <= max / i; ++j) {
                    if (isPrime[j]) {
                        dp[i * j] = true;
                        factors[i * j] = i + j;
                    }
                }
            }
        }
        for (int num : nums) {
            if (dp[num]) {
                res += 1 + num + factors[num];
            }
        }
        return res;
    }
}
