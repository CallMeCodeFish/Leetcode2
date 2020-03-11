package day13;

/**
 * @author Heng Yu
 * @date 3/10/20 7:54 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 163: Missing Ranges
 */

public class MissingRanges {
    public static void main(String[] args) {
        MissingRanges solution = new MissingRanges();
        int[] nums = new int[]{-2147483648,-2147483648,0,2147483647,2147483647};
        List<String> result = solution.findMissingRanges(nums, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(result);
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        //edge case
        if (upper < lower) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        boolean overflow = false;
        for (int num : nums) {
            if (lower <= num && num <= upper) {
                if (lower + 1 == num) {
                    res.add(String.valueOf(lower));
                } else if (lower < num) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(lower);
                    sb.append("->");
                    sb.append(num - 1);
                    res.add(sb.toString());
                }
                lower = num + 1;
                if (lower == Integer.MIN_VALUE) {
                    overflow = true;
                    break;
                }
            } else if (upper < num) {
                break;
            }
        }
        if (lower == upper) {
            res.add(String.valueOf(lower));
        } else if (lower < upper && !overflow) {
            StringBuilder sb = new StringBuilder();
            sb.append(lower);
            sb.append("->");
            sb.append(upper);
            res.add(sb.toString());
        }
        return res;
    }
}
