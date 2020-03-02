package day5;

/**
 * @author Heng Yu
 * @date 3/1/20 6:48 PM
 */

/**
 * leetcode 55: Jump Game
 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return false;

        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (max < i) break;
            max = Math.max(max, i + nums[i]);
            if (nums.length - 1 <= max) return true;
        }
        return false;
    }
}
