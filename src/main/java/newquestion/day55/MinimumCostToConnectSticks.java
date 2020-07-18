package newquestion.day55;

/**
 * @author Heng Yu
 * @date 7/17/20 6:53 PM
 */

import java.util.PriorityQueue;

/**
 * leetcode 1167: Minumum cost to connect sticks
 * solution: greedy
 * ref: https://www.bilibili.com/video/BV114411B7t7?from=search&seid=17376323928333654593
 */
public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int stick : sticks) minHeap.offer(stick);

        int res  = 0;

        while (minHeap.size() > 1) {
            int connect = minHeap.poll() + minHeap.poll();
            res += connect;
            minHeap.offer(connect);
        }

        return res;
    }
}
