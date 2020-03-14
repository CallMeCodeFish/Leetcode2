package day16;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 3/14/20 12:35 AM
 */


public class ContainDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
