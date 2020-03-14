package day16;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 3/14/20 12:38 AM
 */


public class ContainDuplicateII {
    public static void main(String[] args) {
        ContainDuplicateII solution = new ContainDuplicateII();
        int[] nums = new int[]{1, 2, 1};
        boolean result = solution.containsNearbyDuplicate(nums, 0);
        System.out.println(result);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //edge case
        if (nums == null || nums.length == 0 || k == 0) return false;

        Set<Integer> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (k < j - i) {
                set.remove(nums[i++]);
            }
            if (set.contains(nums[j])) return true;
            set.add(nums[j]);
            ++j;
        }
        return false;
    }
}
