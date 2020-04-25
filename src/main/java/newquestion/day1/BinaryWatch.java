package newquestion.day1;

/**
 * @author Heng Yu
 * @date 4/24/20 9:57 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 401: Binary Watch
 */
public class BinaryWatch {
    public static void main(String[] args) {
        BinaryWatch solution = new BinaryWatch();
        List<String> result = solution.readBinaryWatch(9);
        System.out.println(result);
    }

    public List<String> readBinaryWatch(int num) {
        Map<Integer, List<String>> hours = new HashMap<>();
        Map<Integer, List<String>> minutes = new HashMap<>();
        hours.put(0, new ArrayList<>());
        hours.get(0).add("0:");
        minutes.put(0, new ArrayList<>());
        minutes.get(0).add("00");

        int[] nums1 = {1, 2, 4, 8};
        int[] nums2 = {1, 2, 4, 8, 16, 32};

        for (int i = 1; i < 4; ++i) {
            List<String> hour = new ArrayList<>();
            helper(nums1, 0, i, 11, hour, 0);
            hours.put(i, hour);
        }

        for (int i = 1; i <= 5; ++i) {
            List<String> minute = new ArrayList<>();
            helper(nums2, 0, i, 59, minute, 0);
            minutes.put(i, minute);
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i <= num; ++i) {
            if (!hours.containsKey(i)) break;
            if (minutes.containsKey(num - i)) {
                List<String> hour = hours.get(i);
                List<String> minute = minutes.get(num - i);
                for (String h : hour) {
                    for (String m : minute) {
                        res.add(h + m);
                    }
                }
            }
        }
        return res;
    }

    private void helper(int[] nums, int start, int k, int max, List<String> res, int sum) {
        //edge case
        if (k == 0) {
            if (max == 11) {
                StringBuilder sb = new StringBuilder();
                sb.append(sum);
                sb.append(":");
                res.add(sb.toString());
            } else {
                if (sum < 10) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("0");
                    sb.append(sum);
                    res.add(sb.toString());
                } else {
                    res.add(String.valueOf(sum));
                }
            }
            return;
        }

        if (nums.length - start < k) return;

        for (int i = start; i < nums.length; ++i) {
            int num = nums[i];
            if (sum + num > max) break;
            helper(nums, i + 1, k - 1, max, res, sum + num);
        }
    }
}
