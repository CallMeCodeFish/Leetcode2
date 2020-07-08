package newquestion.day50;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Heng Yu
 * @date 7/7/20 8:11 PM
 */

/**
 * leetcode 1353: Maximum number of events that can be attended
 * ref: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/510263/JavaC%2B%2BPython-Priority-Queue
 */
public class MaximumNumberOfEvents {
    public int maxEvents(int[][] events) {
        if (events.length == 1) return 1;

        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int min = events[0][0];
        int max = 0;

        for (int[] e : events) {
            max = Math.max(max, e[1]);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int res = 0;

        int i = 0;

        for (int d = min; d <= max; d++) {
            while (!minHeap.isEmpty() && minHeap.peek() < d) minHeap.poll();
            while (i < events.length && events[i][0] == d) minHeap.offer(events[i++][1]);

            if (!minHeap.isEmpty()) {
                minHeap.poll();
                res++;
            }
        }


        return res;
    }
}
