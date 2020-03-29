package day28;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 3/28/20 8:52 PM
 */

/**
 * leetcode 349: Intersection of Two Arrays
 */

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        //edge case
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];

        Set<Integer> dict = new HashSet<>();
        for (int n : nums1) {
            dict.add(n);
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums2) {
            if (dict.contains(n)) set.add(n);
        }
        int[] res = new int[set.size()];
        int i = 0;
        for (int n : set) {
            res[i++] = n;
        }
        return res;
    }
}
