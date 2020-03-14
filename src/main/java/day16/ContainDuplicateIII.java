package day16;

/**
 * @author Heng Yu
 * @date 3/14/20 1:00 AM
 */

import java.util.TreeSet;

/**
 * leetcode 220: Contains Duplicate III
 */

public class ContainDuplicateIII {
    public static void main(String[] args) {
        ContainDuplicateIII solution = new ContainDuplicateIII();
        int[] nums = new int[]{0, Integer.MAX_VALUE};
        boolean result = solution.containsNearbyAlmostDuplicate(nums, 1, Integer.MAX_VALUE);
        System.out.println(result);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //edge case
        if (t < 0) return false;

        TreeSet<Long> set = new TreeSet<>();
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (k < j - i) {
                set.remove((long) nums[i++]);
            }
            long from = nums[j] - (long) t;
            long to = nums[j] + (long) t;
            if (!set.subSet(from, true, to, true).isEmpty()) return true;
            set.add((long) nums[j]);
            ++j;
        }
        return false;
    }
}
