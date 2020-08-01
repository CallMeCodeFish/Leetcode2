package newquestion.day64;

/**
 * @author Heng Yu
 * @date 8/1/20 5:14 PM
 */

/**
 * leetcode 665: Non-decreasing array
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 1) return true;

        int count = 0;
        int index = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                index = i;
            }
        }

        if (count == 0) return true;
        if (count > 1) return false;
        if (index == 0) return true;
        if (index + 1 == nums.length - 1) return true;

        return nums[index - 1] <= nums[index + 1] || nums[index] <= nums[index + 2];
    }
}
