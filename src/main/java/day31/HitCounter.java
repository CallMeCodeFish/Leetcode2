package day31;

/**
 * @author Heng Yu
 * @date 4/7/20 4:56 PM
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 362: Design Hit Counter
 */

public class HitCounter {
    private Queue<Integer> time;

    /** Initialize your data structure here. */
    public HitCounter() {
        this.time = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        time.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (time.isEmpty()) return 0;
        int oldest = time.peek();
        if (timestamp - oldest >= 300) {
            while (timestamp - oldest >= 300) {
                time.poll();
                if (time.isEmpty()) break;
                oldest = time.peek();
            }
        }
        return time.size();
    }
}
