package day1;

/**
 * @author Heng Yu
 * @date 2/26/20 10:18 PM
 */

/**
 * leetcode 11: Container With Most Water
 */

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] nums = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = solution.maxArea(nums);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            int left = height[i];
            int right = height[j];
            int area = (j - i) * Math.min(left, right);
            res = Math.max(res, area);
            if (left < right) {
                ++i;
            } else {
                --j;
            }
        }
        return res;
    }
}
