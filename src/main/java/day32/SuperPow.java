package day32;

/**
 * @author Heng Yu
 * @date 4/8/20 3:19 PM
 */

/**
 * leetcode 372: Super Pow
 */

public class SuperPow {
    public static void main(String[] args) {
        SuperPow solution = new SuperPow();
        int a = 2;
        int[] b = {1,0};
        int result = solution.superPow(a, b);
        System.out.println(result);
    }

    public int superPow(int a, int[] b) {
        //edge case

        final int MOD = 1337;
        a %= MOD;
        //edge case
        if (a == 1) return 1;

        int[] memo = new int[10];
        memo[0] = 1;
        for (int i = 1; i < memo.length; ++i) {
            memo[i] = memo[i - 1] * a % MOD;
        }
        int res = memo[b[0]];
        for (int i = 1; i < b.length; ++i) {
            int n = 9;
            int copy = res;
            while (n-- > 0) {
                res *= copy;
                res %= MOD;
            }
            res *= memo[b[i]];
            res %= MOD;
        }
        return res;
    }
}
