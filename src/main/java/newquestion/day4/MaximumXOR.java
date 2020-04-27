package newquestion.day4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 4/27/20 6:41 PM
 */


public class MaximumXOR {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 31; i >= 0; --i) {
            mask |= (1 << i);
            set.clear();
            for (int num : nums) {
                set.add(num & mask);
            }
            int expectedMax = max | (1 << i);
            for (int num : set) {
                if (set.contains(num ^ expectedMax)) {
                    max = expectedMax;
                    break;
                }
            }
        }
        return max;
    }
}
