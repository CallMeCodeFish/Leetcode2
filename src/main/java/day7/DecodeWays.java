package day7;

/**
 * @author Heng Yu
 * @date 3/4/20 12:11 AM
 */

import java.util.Arrays;

/**
 * leetcode 91: Decode Ways
 */

public class DecodeWays {
    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();
        int result = solution.numDecodings2("226");
        System.out.println(result);
    }

    public int numDecodings(String s) {
        char[] chs = s.toCharArray();
        int[] memo = new int[chs.length];
        Arrays.fill(memo, -1);
        return helper(chs, 0, memo);
    }

    private int helper(char[] s, int i, int[] memo) {
        //edge case
        if (s.length <= i) return 1;
        if (s[i] == '0') return 0;

        if (memo[i] != -1) return memo[i];
        int res = 0;
        res += helper(s, i + 1, memo);
        int first = s[i] - '0';
        if (i + 1 < s.length && first <= 2) {
            int second = s[i + 1] - '0';
            int num = first * 10 + second;
            if (num <= 26) {
                res += helper(s, i + 2, memo);
            }
        }
        memo[i] = res;
        return res;
    }

    public int numDecodings2(String s) {
        char[] chs = s.toCharArray();
        int[] dp = new int[chs.length];
        for (int i = dp.length - 1; i >= 0; --i) {
            int first = chs[i]  - '0';
            if (first == 0) {
                dp[i] = 0;
            } else {
                if (i + 1 == dp.length) {
                    dp[i] = 1;
                } else {
                    dp[i] += dp[i + 1];
                }
                if (i + 1 < dp.length) {
                    int second = chs[i + 1] - '0';
                    int num = first * 10 + second;
                    if (num <= 26) {
                        if (i + 1 == dp.length - 1) {
                            dp[i] += 1;
                        } else {
                            dp[i] += dp[i + 2];
                        }
                    }
                }
            }
        }
        return dp[0];
    }
}
