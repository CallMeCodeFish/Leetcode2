package day6;

/**
 * @author Heng Yu
 * @date 3/2/20 4:25 PM
 */

/**
 * leetcode 70: Climbing Stairs
 */

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        int result = solution.climbStairs(3);
        System.out.println(result);
    }

    public int climbStairs(int n) {
        //edge case
        if (n == 1) return 1;

        int[] dp = new int[n];
        dp[n - 1] = 1;
        dp[n - 2] = 2;
        for (int i = n - 3; i >= 0; --i) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }
}
