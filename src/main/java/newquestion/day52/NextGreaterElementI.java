package newquestion.day52;

import java.util.*;

/**
 * @author Heng Yu
 * @date 7/11/20 4:23 PM
 */

/**
 * leetcode 496: Next greater element I
 * solution: stack
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            indices.put(nums1[i], i);
        }

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();

        for (int num : nums2) {
            while (!stack.isEmpty() && nums1[stack.peek()] < num) {
                res[stack.pop()] = num;
            }

            if (indices.containsKey(num)) {
                stack.push(indices.get(num));
            }
        }

        return res;
    }
}
