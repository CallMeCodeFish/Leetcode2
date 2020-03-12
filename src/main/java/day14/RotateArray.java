package day14;

/**
 * @author Heng Yu
 * @date 3/11/20 5:08 PM
 */

import java.util.Arrays;

/**
 * leetcode 189: Rotate Array
 */

public class RotateArray {
    public static void main(String[] args) {
        RotateArray solution = new RotateArray();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        int[] memo = new int[k];
        int i = k - 1;
        for (int j = nums.length - 1; j >= nums.length - k; --j) {
            memo[i--] = nums[j];
        }
        for (int j = nums.length - k - 1; j >= 0; --j) {
            nums[j + k] = nums[j];
        }
        for (int j = 0; j < memo.length; ++j) {
            nums[j] = memo[j];
        }
    }
}
