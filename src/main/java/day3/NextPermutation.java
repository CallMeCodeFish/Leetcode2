package day3;

/**
 * @author Heng Yu
 * @date 2/28/20 10:41 PM
 */

import java.util.Arrays;

/**
 * leetcode 31: Next Permutation
 */

public class NextPermutation {
    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] nums = new int[]{2,3,1};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0)   return;

        int j = nums.length - 1;
        boolean flag = false;
        while (0 < j) {
            if (nums[j - 1] < nums[j]) {
                flag = true;
                int i = j - 1;
                j = nums.length - 1;
                while (i < j) {
                    if (nums[i] < nums[j]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                    --j;
                }
                ++i;
                j = nums.length - 1;
                while (i <= j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    ++i;
                    --j;
                }
                break;
            }
            --j;
        }
        if (!flag) {
            int i = 0;
            j = nums.length - 1;
            while (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                ++i;
                --j;
            }
        }
    }
}
