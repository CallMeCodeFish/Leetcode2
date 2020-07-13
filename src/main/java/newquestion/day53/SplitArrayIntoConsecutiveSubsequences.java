package newquestion.day53;

import java.util.PriorityQueue;

/**
 * @author Heng Yu
 * @date 7/12/20 9:22 PM
 */

/**
 * leetcode 659: Split array into consecutive subsequences
 */
public class SplitArrayIntoConsecutiveSubsequences {
    private static class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean isPossible(int[] nums) {
        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> a.end == b.end ? a.end - a.start - (b.end - b.start) : a.end - b.end);

        for (int num : nums) {
            while (!heap.isEmpty() && heap.peek().end + 1 < num) {
                Interval poll = heap.poll();
                if (poll.end - poll.start + 1 < 3) return false;
            }

            if (heap.isEmpty() || heap.peek().end == num) {
                heap.offer(new Interval(num, num));
            } else {
                Interval poll = heap.poll();
                poll.end = num;
                heap.offer(poll);
            }
        }

        while (!heap.isEmpty()) {
            Interval poll = heap.poll();
            if (poll.end - poll.start + 1 < 3) return false;
        }

        return true;
    }
}
