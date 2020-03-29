package day28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 3/28/20 8:59 PM
 */


public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        //edge case
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];

        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums1) {
            if (!freq.containsKey(n)) {
                freq.put(n, 0);
            }
            freq.replace(n, freq.get(n) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (freq.containsKey(n) && freq.get(n) > 0) {
                list.add(n);
                freq.replace(n, freq.get(n) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}
