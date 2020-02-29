package day3;

/**
 * @author Heng Yu
 * @date 2/28/20 5:29 PM
 */

/**
 * leetcode 26: Remove Duplicates
 */

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();
        int[] nums = new int[]{0};
        int result = solution.removeDuplicates(nums);
        System.out.println(result);
    }

    public int removeDuplicates(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0)   return 0;

        int i = 0;
        int j = 1;
        int res = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
                ++res;
            }
            ++j;
        }
        return res;
    }
}
