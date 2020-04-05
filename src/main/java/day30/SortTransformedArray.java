package day30;

/**
 * @author Heng Yu
 * @date 4/4/20 10:07 PM
 */

import java.util.Arrays;

/**
 * leetcode 360: Sort Transformed Array
 */

public class SortTransformedArray {
    public static void main(String[] args) {
        SortTransformedArray solution = new SortTransformedArray();
        int[] nums = {-4, -2, 2, 4};
        int[] result = solution.sortTransformedArray(nums, -1, 3, 5);
        System.out.println(Arrays.toString(result));
    }

    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1, k = nums.length - 1;
        while (i <= j) {
            int left = calculate(a, b, c, nums[i]);
            int right = calculate(a, b, c, nums[j]);
            if (left > right) {
                res[k--] = left;
                ++i;
            } else {
                res[k--] = right;
                --j;
            }
        }
        return res;
    }

    private int calculate(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}
