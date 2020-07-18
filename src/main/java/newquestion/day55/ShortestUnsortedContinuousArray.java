package newquestion.day55;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Heng Yu
 * @date 7/17/20 4:59 PM
 */

/**
 * leetcode 581: Shortest unsorted continuous array
 * solution: stack
 */
public class ShortestUnsortedContinuousArray {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int l = nums.length;

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }

            stack.push(i);
        }

        if (l == nums.length) return 0;

        int r = 0;
        stack = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                r = Math.max(r, stack.pop());
            }

            stack.push(i);
        }

        return r - l + 1;
    }
}
