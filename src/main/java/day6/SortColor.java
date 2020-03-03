package day6;

/**
 * @author Heng Yu
 * @date 3/2/20 5:41 PM
 */

import java.util.Arrays;

/**
 * leetcode 75: Sort Color
 */

public class SortColor {
    public static void main(String[] args) {
        SortColor solution = new SortColor();
        int[] nums = new int[]{2, 0, 1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return;

        int l = 0;
        int r = nums.length - 1;
        int cur = 0;
        while (cur <= r) {
            if (nums[cur] == 0) {
                int temp = nums[l];
                nums[l] = nums[cur];
                nums[cur] = temp;
                ++l;
                ++cur;
            } else if (nums[cur] == 1) {
                ++cur;
            } else {
                int temp = nums[r];
                nums[r--] = nums[cur];
                nums[cur] = temp;
            }
        }
    }
}
