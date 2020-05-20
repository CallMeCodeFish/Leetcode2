package newquestion.day19;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @author Heng Yu
 * @date 5/19/20 4:01 PM
 */

/**
 * leetcode 636: Exclusive time of functions
 */
public class ExclusiveTime {
    private static class Timestamp {
        int id;
        int timestamp;
        int type; //1: start   -1: end

        public Timestamp(int id, int timestamp, int type) {
            this.id = id;
            this.timestamp = timestamp;
            this.type = type;
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        int len = logs.size();
        Timestamp[] times = new Timestamp[len];
        for (int i = 0; i < len; ++i) {
            String log = logs.get(i);
            String[] split = log.split(":");
            int id = Integer.parseInt(split[0]);
            int type = ("start".equals(split[1]))? 1 : -1;
            int timestamp = Integer.parseInt(split[2]);
            if (type == -1) ++timestamp;
            times[i] = new Timestamp(id, timestamp, type);
        }

        Deque<Timestamp> stack = new ArrayDeque<>();

        int[] res = new int[n];

        for (Timestamp t : times) {
            if (stack.isEmpty()) {
                stack.push(t);
            } else {
                if (t.type == 1) { // start
                    Timestamp peek = stack.peek();
                    res[peek.id] += t.timestamp - peek.timestamp;
                    stack.push(t);
                } else { // end
                    Timestamp pop = stack.pop();
                    res[pop.id] += t.timestamp - pop.timestamp;
                    if (!stack.isEmpty()) stack.peek().timestamp = t.timestamp;
                }
            }
        }

        return res;
    }
}
