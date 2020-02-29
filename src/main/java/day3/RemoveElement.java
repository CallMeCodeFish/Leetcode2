package day3;

/**
 * @author Heng Yu
 * @date 2/28/20 6:03 PM
 */

import java.util.Arrays;

/**
 * leetcode 27: Remove Element
 */

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int result = solution.removeElement(nums, 2);
        System.out.println(result);
    }

    public int removeElement(int[] nums, int val) {
        //edge case
        if (nums == null || nums.length == 0)   return 0;

        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (val != nums[j]) {
                nums[i++] = nums[j];
            }
            ++j;
        }
        return i;
    }
}
