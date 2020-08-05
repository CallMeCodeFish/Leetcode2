package newquestion.day65;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Tim
 * @date 8/5/20 6:43 PM
 */

/**
 * leetcode 862: Shortest Subarray with sum at least K
 * solution: sliding window
 * ref: https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/solution/
 */
public class ShortestSubarray {
    public int shortestSubarray(int[] A, int K) {
        int len = A.length;
        int[] prefix = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefix[i] = prefix[i - 1] + A[i - 1];
        }

        Deque<Integer> deque = new LinkedList<>();

        int res = Integer.MAX_VALUE;

        for (int i = 0; i <= len; i++) {
            while (!deque.isEmpty() && prefix[deque.peekFirst()] <= prefix[i] - K) {
                int j = deque.pollFirst();
                res = Math.min(res, i - j);
            }

            while (!deque.isEmpty() && prefix[deque.peekLast()] >= prefix[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
