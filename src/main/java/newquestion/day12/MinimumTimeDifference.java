package newquestion.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Heng Yu
 * @date 5/9/20 4:21 PM
 */

/**
 * leetcode 539: Minimum time difference
 */
public class MinimumTimeDifference {
    public static void main(String[] args) {
        MinimumTimeDifference solution = new MinimumTimeDifference();
        int result = solution.findMinDifference(Arrays.asList("23:59", "00:00"));
        System.out.println(result);
    }

    public int findMinDifference1(List<String> timePoints) {
        List<Integer> list = new ArrayList<>();

        for (String time : timePoints) {
            String[] splits = time.split(":");
            int hour = Integer.parseInt(splits[0]);
            int minute = Integer.parseInt(splits[1]);
            int sum = hour * 60 + minute;
            list.add(sum);
            if (hour < 12) {
                list.add(sum + 24 * 60);
            }
        }

        list.sort(Integer::compareTo);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; ++i) {
            res = Math.min(res, list.get(i + 1) - list.get(i));
        }

        return res;
    }

    public int findMinDifference(List<String> timePoints) {
        boolean[] memo = new boolean[48 * 60];

        for (String time : timePoints) {
            String[] splits = time.split(":");
            int hour = Integer.parseInt(splits[0]);
            int minute = Integer.parseInt(splits[1]);
            int sum = hour * 60 + minute;
            if (memo[sum]) return 0;
            memo[sum] = true;
            if (hour < 12) {
                memo[sum + 24 * 60] = true;
            }
        }

        int res = Integer.MAX_VALUE;
        int i = 0;
        while (i < memo.length) {
            if (memo[i]) break;
            ++i;
        }

        int j = i + 1;
        while (j < memo.length) {
            if (memo[j]) {
                res = Math.min(res, j - i);
                i = j;
            }
            ++j;
        }

        return res;
    }
}
