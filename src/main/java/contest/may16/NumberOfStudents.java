package contest.may16;

/**
 * @author Heng Yu
 * @date 5/16/20 10:30 PM
 */


public class NumberOfStudents {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        int len = startTime.length;

        for (int i = 0; i < len; ++i) {
            int start = startTime[i];
            int end = endTime[i];
            if (start <= queryTime && queryTime <= end) ++res;
        }

        return res;
    }
}
