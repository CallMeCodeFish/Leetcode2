package day22;

/**
 * @author Heng Yu
 * @date 3/19/20 12:21 PM
 */

import java.util.Arrays;

/**
 * leetcode 280: Wiggle Sort
 */

public class WiggleSort {
    public static void main(String[] args) {
        WiggleSort solution = new WiggleSort();
        int[] nums = new int[]{};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            if (i % 2 == 0 && nums[i] > nums[i + 1] || i % 2 != 0 && nums[i] < nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }
}
