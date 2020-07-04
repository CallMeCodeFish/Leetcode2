package newquestion.day47;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 7/3/20 6:27 PM
 */

/**
 * leetcode 352: Data stream as disjoint intervals
 */
public class SummaryRanges {
    private List<int[]> intervals;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        intervals = new ArrayList<>();
    }

    public void addNum(int val) {
        int size = intervals.size();
        int rIndex = binSearch(val);
        if (rIndex == size) {
            int lIndex = rIndex - 1;
            if (lIndex >= 0) {
                int[] lInterval = intervals.get(lIndex);
                if (lInterval[1] + 1 == val) {
                    lInterval[1] = val;
                } else if (lInterval[1] + 1 < val) {
                    intervals.add(new int[]{val, val});
                }
            } else {
                intervals.add(new int[]{val, val});
            }
        } else {
            int[] rInterval = intervals.get(rIndex);
            int lIndex = rIndex - 1;
            if (lIndex >= 0) {
                int[] lInterval = intervals.get(lIndex);
                if (lInterval[1] + 1 == val && val + 1 == rInterval[0]) {
                    lInterval[1] = rInterval[1];
                    intervals.remove(rIndex);
                } else if (lInterval[1] + 1 == val) {
                    lInterval[1] = val;
                } else if (val + 1 == rInterval[0]) {
                    rInterval[0] = val;
                } else if (val < rInterval[0] - 1) {
                    intervals.add(rIndex, new int[]{val, val});
                }
            } else {
                if (val < rInterval[0] - 1) {
                    intervals.add(rIndex, new int[]{val, val});
                } else if (val == rInterval[0] - 1) {
                    rInterval[0] = val;
                }
            }
        }
    }

    private int binSearch(int val) {
        int l = 0, r = intervals.size();

        while (l < r) {
            int mid = l + (r - l) / 2;
            int[] interval = intervals.get(mid);
            if (val <= interval[1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public int[][] getIntervals() {
        int size = intervals.size();

        int[][] res = new int[size][];
        for (int i = 0; i < size; i++) {
            res[i] = intervals.get(i);
        }

        return res;
    }
}
