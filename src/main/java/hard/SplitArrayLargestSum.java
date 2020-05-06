package hard;

/**
 * @author Heng Yu
 * @date 5/2/20 9:35 PM
 */

/**
 * leetcode 410: Split Array Largest Sum
 */
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        SplitArrayLargestSum solution = new SplitArrayLargestSum();
        int[] nums = {7,2,5,10,8}; //5
//        int[] nums = {2,4,3}; //2 7,2,5,10,8
        int result = solution.splitArray2(nums, 2);
        System.out.println(result);
    }

    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[][][] dp = new int[m + 1][len][len];
        for (int i = 1; i < len; ++i) {
            nums[i] += nums[i - 1];
        }

        return helper(dp, m, 0, len - 1, nums, true);
    }

    private int helper(int[][][] dp, int m, int start, int end, int[] nums, boolean flag) {
        if (dp[m][start][end] != 0) return dp[m][start][end];

        if (m == 1) {
            int res = (start == 0)? nums[end] : nums[end] - nums[start - 1];
            dp[m][start][end] = res;
            return res;
        }

        if (end - start + 1 < m) {
            dp[m][start][end] = -1;
            return -1;
        }

        int min = Integer.MAX_VALUE;
        if (flag) {
            for (int i = start; i < end; ++i) {
               int left = nums[i];
               int right = helper(dp, m - 1, i + 1, end, nums, false);
               if (right > 0) min = Math.min(min, Math.max(left, right));
            }
        } else {
            for (int i = start; i < end; ++i) {
                int left = (start == 0)? nums[i] : nums[i] - nums[start - 1];
                int right = helper(dp, m - 1, i + 1, end, nums, false);
                if (right > 0) min = Math.min(min, Math.max(left, right));
            }
            dp[m][start][end] = min;
        }
        return min;
    }

    public int splitArray2(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        int[] sub = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }
}
