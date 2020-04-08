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
        if (a == 0) {
            if (b >= 0) {
                for (int i = 0; i < nums.length; ++i) {
                    res[i] = calculate(a, b, c, nums[i]);
                }
            } else {
                int j = 0;
                for (int i = nums.length - 1; i >= 0; --i) {
                    res[j++] = calculate(a, b, c, nums[i]);
                }
            }
        } else {
            int i = 0;
            int j = nums.length - 1;
            if (a > 0) {
                int k = res.length - 1;
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
            } else {
                int k = 0;
                while (i <= j) {
                    int left = calculate(a, b, c, nums[i]);
                    int right = calculate(a, b, c, nums[j]);
                    if (left > right) {
                        res[k++] = right;
                        --j;
                    } else {
                        res[k++] = left;
                        ++i;
                    }
                }
            }
        }
        return res;
    }

    private int calculate(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}
