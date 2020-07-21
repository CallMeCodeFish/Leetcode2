package newquestion.day58;

/**
 * @author Heng Yu
 * @date 7/20/20 4:00 PM
 */

/**
 * leetcode 724: Find pivot index
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == 2 * cur) return i;
            cur += nums[i];
        }

        return -1;
    }

    public int pivotIndex1(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            if (left[i] == right[i]) return i;
        }

        return -1;
    }
}
