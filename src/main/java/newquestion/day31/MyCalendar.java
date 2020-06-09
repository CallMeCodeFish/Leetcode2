package newquestion.day31;

/**
 * @author Heng Yu
 * @date 6/8/20 4:12 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 729: My calendar I
 */
public class MyCalendar {
    private final List<int[]> intervals;

    public MyCalendar() {
        intervals = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        List<int[]> intervals = this.intervals;

        boolean canBook = true;
        for (int[] interval : intervals) {
            if (start < interval[1] && start >= interval[0] || interval[0] < end && interval[0] >= start) {
                canBook = false;
                break;
            }
        }

        if (canBook) {
            intervals.add(new int[]{start, end});
        }

        return canBook;
    }
}
