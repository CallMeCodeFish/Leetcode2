package contest.may23;

/**
 * @author Heng Yu
 * @date 5/23/20 10:49 PM
 */


public class MaxDotProduct {
    public static void main(String[] args) {
        MaxDotProduct solution = new MaxDotProduct();

        int[] nums1 = {-3,-8,3,-10,1,3,9};
        int[] nums2 = {9,2,3,7,-9,1,-8,5,-1,-1};

        int result = solution.maxDotProduct(nums1, nums2);
        System.out.println(result);
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[][] dp = new int[len1][len2];

        dp[0][0] = nums1[0] * nums2[0];

        for (int i = 1; i < len1; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
        }

        for (int j = 1; j < len2; ++j) {
            dp[0][j] = Math.max(dp[0][j - 1], nums1[0] * nums2[j]);
        }

        for (int i = 1; i < len1; ++i) {
            for (int j = 1; j < len2; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i] * nums2[j]);
                dp[i][j] = Math.max(dp[i][j], nums1[i] * nums2[j]);
            }
        }

        return dp[len1 - 1][len2 - 1];
    }
}
