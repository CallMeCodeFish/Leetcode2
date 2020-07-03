package newquestion.day46;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Heng Yu
 * @date 7/2/20 6:14 PM
 */

/**
 * leetcode 907: Sum of subarray minimums
 * solution: stack
 */
public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        final int MOD = 1000000000 + 7;
        int len = A.length;
        int[] prev = new int[len];
        int[] next = new int[len];

        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(i);
        }

        stack = new LinkedList<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] < A[stack.peek()]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? len : stack.peek();
            stack.push(i);
        }

        long res = 0;
        for (int i = 0; i < len; i++) {
            int count = (i - prev[i]) * (next[i] - i);
            res += count * A[i];
            res %= MOD;
        }

        return (int) res;
    }
}
