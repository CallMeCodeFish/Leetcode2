package newquestion.day29;

/**
 * @author Heng Yu
 * @date 6/4/20 3:36 PM
 */

/**
 * leetcode 312: Burst balloons
 * solution: https://www.bilibili.com/video/BV1pa4y147Ue?from=search&seid=16514278881552505007
 */
public class BurstBalloons {
    public static void main(String[] args) {
        BurstBalloons solution = new BurstBalloons();
        int[] nums = {1,3,5,8,1};
        int result = solution.maxCoins(nums);
        System.out.println(result);
    }

    public int maxCoins(int[] nums) {
        int len = nums.length;
        int n = len + 2;
        int[] arr = new int[n];
        arr[0] = arr[n - 1] = 1;
        for (int i = 1; i <= len; i++) {
            arr[i] = nums[i - 1];
        }

        int[][] dp = new int[n][n];

        for (int i = 1; i <= len; i++) {
            dp[i][i] = arr[i - 1] * arr[i] * arr[i + 1];
        }

        for (int m = 1; m < len; m++) {
            for (int i = 1; i < len; i++) {
                int j = i + m;
                if (j > len) break;

                for (int k = i; k <= j; k++) {
                    int cur = dp[i][k - 1] + dp[k + 1][j] + arr[k] * arr[i - 1] * arr[j + 1];
                    dp[i][j] = Math.max(dp[i][j], cur);
                }
            }
        }

        return dp[1][len];
    }
}
