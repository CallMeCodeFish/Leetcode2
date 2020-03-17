package day19;

/**
 * @author Heng Yu
 * @date 3/16/20 6:32 PM
 */

import java.util.Arrays;

/**
 * leetcode 252: Meeting Rooms
 */

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 1) return true;

        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; ++i) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < len) {
            if (starts[i] < ends[j]) {
                ++count;
                if (1 < count) return false;
                ++i;
            } else {
                ++i;
                ++j;
            }
        }
        return true;
    }
}
