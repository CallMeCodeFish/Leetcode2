package hard;

/**
 * @author Heng Yu
 * @date 5/4/20 10:29 PM
 */

/**
 * leetcode 42: Trapping rain water
 */
public class TrapRainWater {
    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 1; i < len - 1; ++i) {
            left[i] = Math.max(height[i - 1], left[i - 1]);
        }

        for (int i = len - 2; i > 0; --i) {
            right[i] = Math.max(height[i + 1], right[i + 1]);
        }

        int res = 0;

        for (int i = 1; i < len - 1; ++i) {
            int min = Math.min(left[i], right[i]);
            if (height[i] < min) {
                res += min - height[i];
            }
        }

        return res;
    }
}
