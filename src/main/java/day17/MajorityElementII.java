package day17;

/**
 * @author Heng Yu
 * @date 3/14/20 8:40 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 229: Majority Element II
 */

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return new ArrayList<>();

        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (count1 == 0 && count2 == 0) {
                num1 = num;
                ++count1;
            } else if (count1 == 0) {
                if (num == num2) {
                    ++count2;
                } else {
                    num1 = num;
                    ++count1;
                }
            } else if (count2 == 0) {
                if (num == num1) {
                   ++count1;
                } else {
                    num2 = num;
                    ++count2;
                }
            } else {
                if (num == num1) {
                    ++count1;
                } else if (num == num2) {
                    ++count2;
                } else {
                    --count1;
                    --count2;
                }
            }
        }
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                ++count1;
            } else if (num == num2) {
                ++count2;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (nums.length / 3 < count1) res.add(num1);
        if (nums.length / 3 < count2) res.add(num2);
        return res;
    }
}
