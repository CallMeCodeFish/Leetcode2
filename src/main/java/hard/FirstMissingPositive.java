package hard;

/**
 * @author Heng Yu
 * @date 5/11/20 5:56 PM
 */

/**
 * leetcode 41: First missing positive
 * solution: 1. 遍历数组，找到小于等于0的元素，重新赋值为0.
 *           2. 如果值为0的元素被visit了，将其重新赋值为Integer.MIN_VALUE
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) nums[i] = 0;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0 && nums[i] != Integer.MIN_VALUE) {
                int index = Math.abs(nums[i]) - 1;
                if (index < nums.length) {
                    if (nums[index] > 0) {
                        nums[index] = -nums[index];
                    } else if (nums[index] == 0) {
                        nums[index] = Integer.MIN_VALUE;
                    }
                }
            }
        }

        int res = nums.length + 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] >= 0) {
                res = i + 1;
                break;
            }
        }

        return res;
    }
}
