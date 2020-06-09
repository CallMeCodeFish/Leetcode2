package newquestion.day31;

/**
 * @author Heng Yu
 * @date 6/8/20 6:17 PM
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 84: Largest rectangle in histogram
 * solution: stack
 */
public class LargestRectangle {
    public static void main(String[] args) {
        LargestRectangle solution = new LargestRectangle();
        int[] heights = {2,1,5,6,2,3};
        int result = solution.largestRectangleArea(heights);
        System.out.println(result);
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] nums = new int[len + 2];

        System.arraycopy(heights, 0, nums, 1, len);

        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;

        for (int i = 0; i < len + 2; i++) {
            if (stack.isEmpty() || nums[i] >= nums[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    int height = nums[stack.pop()];
                    int width = i - stack.peek() - 1;
                    res = Math.max(res, height * width);
                }
                stack.push(i);
            }
        }

        return res;
    }

    public int largestRectangleArea1(int[] heights) {
        if (heights.length == 0) return 0;

        int len = heights.length;
        int[] dp = new int[len];
        dp[0] = heights[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(heights[i], dp[i - 1]);

            int min = heights[i];
            for (int j = i - 1; j >= 0; j--) {
                min = Math.min(min, heights[j]);
                dp[i] = Math.max(dp[i], min * (i - j + 1));
            }
        }

        return dp[len - 1];
    }
}
