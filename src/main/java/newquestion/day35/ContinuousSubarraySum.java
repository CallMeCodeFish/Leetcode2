package newquestion.day35;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 6/13/20 6:20 PM
 */

/**
 * leetcode 523: Continuous subarray sum
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }

            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) return true;
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }
}
