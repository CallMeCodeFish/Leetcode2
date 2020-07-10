package newquestion.day51;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Heng Yu
 * @date 7/9/20 4:16 PM
 */

/**
 * leetcode 503: Next greater element II
 * solution: stack
 * ref: https://leetcode.com/problems/next-greater-element-ii/discuss/98270/JavaC%2B%2BPython-Loop-Twice
 */
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }

        return res;
    }

    /**
     * naive approach
     * @param nums
     * @return
     */
    public int[] nextGreaterElements1(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];
        Arrays.fill(res, -1);

        for (int i = 0; i < len; i++) {
            int j = i + 1;
            if (j == len) j = 0;
            while (j != i) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
                j++;
                if (j == len) j = 0;
            }
        }

        return res;
    }
}
