package newquestion.day56;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Heng Yu
 * @date 7/18/20 4:43 PM
 */

/**
 * leetcode 846: Hands of straights
 * solution: bucket sorting
 */
public class HandOfStraights {
    private static class Info {
        int size;
        int last;

        public Info(int last) {
            this.size = 1;
            this.last = last;
        }
    }

    public boolean isNStraightHand(int[] hand, int W) {
        if (W == 1) return true;

        Arrays.sort(hand);

        PriorityQueue<Info> minHeap = new PriorityQueue<>((a, b) -> a.last != b.last ? a.last - b.last : a.size - b.size);

        for (int i = 0; i < hand.length; i++) {
            int num = hand[i];
            if (!minHeap.isEmpty()) {
                int last = minHeap.peek().last;
                if (last + 1 < num) return false;

                if (last + 1 == num) {
                    Info poll = minHeap.poll();
                    if (++poll.size != W) {
                        poll.last = num;
                        minHeap.offer(poll);
                    }
                } else {
                    minHeap.offer(new Info(num));
                }
            } else {
                minHeap.offer(new Info(num));
            }
        }

        return minHeap.isEmpty();
    }
}
