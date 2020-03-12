package day14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Heng Yu
 * @date 3/11/20 3:23 PM
 */


public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber solution = new LargestNumber();
        int[] nums = new int[]{3, 30, 34, 5, 9};
        String result = solution.largestNumber(nums);
        System.out.println(result);
    }

    public String largestNumber(int[] nums) {
        //edge case
        if (nums.length == 1) return String.valueOf(nums[0]);

        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String candidate1 = s1 + s2;
                String candidate2 = s2 + s1;
                return candidate2.compareTo(candidate1);
            }
        });
        for (String s : strs) {
            sb.append(s);
        }
        if ('0' == sb.charAt(0)) return "0";
        return sb.toString();
    }
}
