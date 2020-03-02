package day5;

/**
 * @author Heng Yu
 * @date 3/1/20 7:30 PM
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * leetcode 56: Merge Intervals
 */

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(intervals);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public int[][] merge(int[][] intervals) {
        //edge case
        if (intervals == null || intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int len = 1;
        for (int i = 1; i < intervals.length; ++i) {
            int[] cur = intervals[i];
            int[] pre = intervals[len - 1];
            if (cur[0] <= pre[1]) {
                if (pre[1] < cur[1]) {
                    pre[1] = cur[1];
                }
            } else {
                intervals[len][0] = cur[0];
                intervals[len][1] = cur[1];
                ++len;
            }
        }

        int[][] res = new int[len][];
        for (int i = 0; i < len; ++i) {
            res[i] = intervals[i];
        }
        return res;
    }
}
