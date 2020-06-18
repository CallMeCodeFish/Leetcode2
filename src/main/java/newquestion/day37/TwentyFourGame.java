package newquestion.day37;

/**
 * @author Heng Yu
 * @date 6/17/20 9:05 PM
 */

/**
 * leetcode 679: 24 game
 * ref: https://www.bilibili.com/video/BV12J41187Z8?from=search&seid=17321198191975451068
 */
public class TwentyFourGame {
    public boolean judgePoint24(int[] nums) {
        double[] arr = new double[]{nums[0], nums[1], nums[2], nums[3]};

        return backtracking(arr);
    }

    private boolean backtracking(double[] nums) {
        if (nums.length == 1) return Math.abs(nums[0] - 24) < 0.0001;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                double[] next = new double[nums.length - 1];
                for (int k = 0, w = 0; k < nums.length; k++) {
                    if (k != i && k != j) next[w++] = nums[k];
                }

                for (double num : computeAll(nums[i], nums[j])) {
                    next[next.length - 1] = num;
                    if (backtracking(next)) return true;
                }
            }
        }

        return false;
    }

    private double[] computeAll(double x, double y) {
        return new double[]{x + y, x - y, y - x, x * y, x / y, y / x};
    }
}
