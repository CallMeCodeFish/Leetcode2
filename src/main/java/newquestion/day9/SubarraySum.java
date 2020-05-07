package newquestion.day9;

/**
 * @author Heng Yu
 * @date 5/6/20 6:08 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 560: Subarray sum equal to K
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res = 0;

        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            int count = map.getOrDefault(sum, 0);
            map.put(sum, count + 1);
        }

        return res;
    }
}
