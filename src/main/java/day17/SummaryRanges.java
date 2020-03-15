package day17;

/**
 * @author Heng Yu
 * @date 3/14/20 8:31 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 228: Summary Ranges
 */

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (j < nums.length - 1 && nums[j] + 1 == nums[j + 1]) ++j;
            if (i == j) {
                res.add(String.valueOf(nums[i]));
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                sb.append("->");
                sb.append(nums[j]);
                res.add(sb.toString());
            }
            i = j + 1;
        }
        return res;
    }
}
