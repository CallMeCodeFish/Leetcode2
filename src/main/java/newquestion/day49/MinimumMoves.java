package newquestion.day49;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 7/6/20 6:27 PM
 */

/**
 * leetcode 453: Minimum moves to equal array elements
 */
public class MinimumMoves {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            res += nums[i] - nums[0];
        }

        return res;
    }
}
