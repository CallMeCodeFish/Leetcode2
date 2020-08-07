package newquestion.day66;


import java.util.Arrays;

/**
 * leetcode 1155: Number of dice rolls with target sum
 * solution: recursion with memorization
 */
public class NumberOfDiceRolls {
    private final int mod = 1000000007;

    public int numRollsToTarget(int d, int f, int target) {
        long[][] memo = new long[d + 1][target + 1];

        for (int i = 0; i <= d; i++) {
            Arrays.fill(memo[i], -1);
        }

        int res = (int) helper(d, f, target, memo);

        return res;
    }

    private long helper(int d, int f, int target, long[][] memo) {
        if (target <= 0) return 0;

        if (memo[d][target] != -1) return memo[d][target];

        long res = 0;

        if (d == 1) {
            if (target <= f) res = 1;
            memo[d][target] = res;
            return res;
        }

        for (int i = 1; i <= f; i++) {
            res += helper(d - 1, f, target - i, memo);
            res %= mod;
        }

        memo[d][target] = res;

        return res;
    }
}
