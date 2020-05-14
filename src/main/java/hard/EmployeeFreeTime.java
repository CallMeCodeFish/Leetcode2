package hard;

/**
 * @author Heng Yu
 * @date 5/13/20 6:28 PM
 */

import java.util.*;

/**
 * leetcode 759: Employee free time
 */
public class EmployeeFreeTime {
    private static class Interval {
        int start;
        int end;

        public Interval() {
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> list = new ArrayList<>();
        for (List<Interval> s : schedule) {
            list.addAll(s);
        }

        list.sort((a, b) -> a.start - b.start);

        PriorityQueue<Interval> heap = new PriorityQueue<>((a, b) -> b.end - a.end);

        for (Interval interval : list) {
            if (heap.isEmpty()) {
                heap.offer(interval);
            } else {
                Interval poll = heap.poll();
                if (interval.start <= poll.end) {
                    poll.end = Math.max(poll.end, interval.end);
                    heap.offer(poll);
                } else {
                    heap.offer(poll);
                    heap.offer(interval);
                }
            }
        }

        List<Interval> res = new ArrayList<>();
        int end = heap.poll().start;
        while (!heap.isEmpty()) {
            Interval poll = heap.poll();
            res.add(new Interval(poll.end, end));
            end = poll.start;
        }

        Collections.reverse(res);

        return res;
    }
}
