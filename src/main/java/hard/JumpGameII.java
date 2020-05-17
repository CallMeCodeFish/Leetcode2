package hard;

/**
 * @author Heng Yu
 * @date 5/16/20 5:08 PM
 */

import java.util.Arrays;

/**
 * leetcode 45: Jump game II
 * solution: refer to leetcode solution area
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length < 2) return 0;

        int maxPos = nums[0]; //从当前位置起跳能到的最远位置
        int limit = nums[0]; //当前次跳跃的最远起跳位置

        int res = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (limit < i) {
                ++res;
                limit = maxPos;
            }
            maxPos = Math.max(maxPos, i + nums[i]);
        }

        return res;
    }

    public int jump1(int[] nums) {
        int len = nums.length;
        int[] steps = new int[len];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;

        for (int i = 0; i < len; ++i) {
            for (int offset = 1; offset <= nums[i]; ++offset) {
                int j = i + offset;
                if (j >= len) break;

                steps[j] = Math.min(steps[j], steps[i] + 1);
            }
        }

        return steps[len - 1];
    }
}
