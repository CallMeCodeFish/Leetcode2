package day1;

/**
 * @author Heng Yu
 * @date 2/26/20 5:53 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 1: Two Sum
 *
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                List<Integer> indices = map.get(target - nums[i]);
                for (int index : indices) {
                    if (index != i) {
                        res[0] = i;
                        res[1] = index;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
