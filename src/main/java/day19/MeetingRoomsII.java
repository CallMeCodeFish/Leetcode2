package day19;

/**
 * @author Heng Yu
 * @date 3/16/20 6:52 PM
 */

import java.util.Arrays;

/**
 * leetcode 253: Meeting Rooms II
 */

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        for (int i = 0; i < len; ++i) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0;
        int i = 0;
        int j = 0;
        while (i < len) {
            if (starts[i] < ends[j]) {
                ++res;
                ++i;
            } else {
                ++i;
                ++j;
            }
        }
        return res;
    }
}
