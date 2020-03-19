package day22;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 3/19/20 3:45 PM
 */


public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
            ++j;
        }
    }
}
