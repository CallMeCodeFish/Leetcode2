package day21;

/**
 * @author Heng Yu
 * @date 3/18/20 10:35 PM
 */


public class PerfectSquares {
    public static void main(String[] args) {
        PerfectSquares solution = new PerfectSquares();
        int result = solution.numSquares(12);
        System.out.println(result);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            int max = (int) Math.sqrt(i);
            int res = Integer.MAX_VALUE;
            if (max * max == i) {
                res = 1;
            } else {
                for (int j = 1; j <= max; ++j) {
                    int first = j * j;
                    int second = i - first;
                    res = Math.min(res, dp[first] + dp[second]);
                }
            }
            dp[i] = res;
        }
        return dp[n];
    }
}
