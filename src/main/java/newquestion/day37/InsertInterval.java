package newquestion.day37;

/**
 * @author Heng Yu
 * @date 6/17/20 5:04 PM
 */

/**
 * leetcode 57: Insert interval
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res;

        int startIndex = binSearch(intervals, newInterval[0]);
        if (startIndex == intervals.length) {
            if (startIndex != 0 && intervals[startIndex - 1][1] >= newInterval[0]) {
                intervals[intervals.length - 1][1] = Math.max(intervals[intervals.length - 1][1], newInterval[1]);
                return intervals;
            } else {
                int len = intervals.length + 1;
                res = new int[len][];
                for (int i = 0; i < len; i++) {
                    if (i == len - 1) {
                        res[i] = newInterval;
                    } else {
                        res[i] = intervals[i];
                    }
                }
            }
        } else {
            int endIndex = binSearch(intervals, newInterval[1]);
            int len = intervals.length + 1 - (endIndex - startIndex);
            if (startIndex == endIndex) {
                if (startIndex == 0 || intervals[startIndex - 1][1] < newInterval[0]) {
                    res = new int[len][];
                    for (int i = 0; i < len; i++) {
                        if (i < startIndex) {
                            res[i] = intervals[i];
                        } else if (i == startIndex) {
                            res[i] = newInterval;
                        } else {
                            res[i] = intervals[i - 1];
                        }
                    }
                } else {
                    len--;
                    res = new int[len][];
                    for (int i = 0; i < len; i++) {
                        if (i == startIndex - 1) {
                            intervals[i][1] = Math.max(intervals[i][1], newInterval[1]);
                        }
                        res[i] = intervals[i];
                    }
                }
            } else {
                if (startIndex == 0 || intervals[startIndex - 1][1] < newInterval[0]) {
                    res = new int[len][];
                    int i = 0;
                    while (i < startIndex) {
                        res[i] = intervals[i];
                        i++;
                    }

                    newInterval[1] = Math.max(newInterval[1], intervals[endIndex - 1][1]);
                    res[i++] = newInterval;

                    for (int j = endIndex; j < intervals.length; j++) {
                        res[i++] = intervals[j];
                    }

                } else {
                    len--;
                    res = new int[len][];
                    int i = 0;
                    while (i < startIndex - 1) {
                        res[i] = intervals[i];
                        i++;
                    }

                    intervals[i][1] = Math.max(newInterval[1], intervals[endIndex - 1][1]);
                    res[i] = intervals[i];
                    i++;

                    for (int j = endIndex; j < intervals.length; j++) {
                        res[i++] = intervals[j];
                    }
                }
            }
        }

        return res;
    }

    private int binSearch(int[][] intervals, int target) {
        int l = 0, r = intervals.length;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (intervals[mid][0] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
