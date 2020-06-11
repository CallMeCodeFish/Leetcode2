package newquestion.day33;

/**
 * @author Heng Yu
 * @date 6/10/20 4:11 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 532: K-diff pairs in an array
 */
public class DifferentPairs {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int res = 0;

        if (k == 0) {
            for (int key : freq.keySet()) {
                if (freq.get(key) > 1) res++;
            }
            return res;
        }

        for (int num1 : freq.keySet()) {
            int num2 = k + num1;
            if (freq.containsKey(num2)) res++;
        }

        return res;
    }
}
