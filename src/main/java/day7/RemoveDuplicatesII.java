package day7;

/**
 * @author Heng Yu
 * @date 3/3/20 6:16 PM
 */

/**
 * leetcode 80: Remove Duplicates from Sorted Array II
 */

public class RemoveDuplicatesII {
    public static void main(String[] args) {
        RemoveDuplicatesII solution = new RemoveDuplicatesII();
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int result = solution.removeDuplicates(nums);
        System.out.println(result);
    }

    public int removeDuplicates(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return 0;

        int i = 1;
        int j = 1;
        int count = 1;
        while (j < nums.length) {
            if (nums[j] == nums[i - 1]) {
                ++count;
                if (2 < count) {
                    ++j;
                } else {
                    nums[i++] = nums[j++];
                }
            } else {
                count = 1;
                nums[i++] = nums[j++];
            }
        }
        return i;
    }
}
