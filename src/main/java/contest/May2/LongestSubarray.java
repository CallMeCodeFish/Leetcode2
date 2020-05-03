package contest.May2;

import java.util.TreeMap;

/**
 * @author Heng Yu
 * @date 5/2/20 10:53 PM
 */


public class LongestSubarray {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int res = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            int count = map.getOrDefault(nums[j], 0);
            map.put(nums[j], count + 1);
            int min = map.firstKey();
            int max = map.lastKey();
            if (max - min <= limit) {
                res = Math.max(res, j - i + 1);
            } else {
                while (i < j) {
                    map.replace(nums[i], map.get(nums[i]) - 1);
                    if (map.get(nums[i]) == 0) {
                        map.remove(nums[i]);
                        min = map.firstKey();
                        max = map.lastKey();
                        if (max - min <= limit) {
                            ++i;
                            break;
                        }
                    }
                    ++i;
                }
            }
            ++j;
        }

        return res;
    }
}
