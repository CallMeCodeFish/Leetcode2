package newquestion.day3;

/**
 * @author Heng Yu
 * @date 4/26/20 7:13 PM
 */

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 414: Third maximum number
 */
public class ThirdMaximum {
    public static void main(String[] args) {
        ThirdMaximum solution = new ThirdMaximum();
        int[] nums = {2,2,3,1};
        int result = solution.thirdMax(nums);
        System.out.println(result);
    }

    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int firstMax = Integer.MIN_VALUE;
        for (int num : set) {
            if (num > firstMax) {
                firstMax = num;
            }
        }

        if (set.size() < 3) return firstMax;

        int secondMax = Integer.MIN_VALUE;
        for (int num : set) {
            if (num > secondMax && num < firstMax) {
                secondMax = num;
            }
        }

        int res = Integer.MIN_VALUE;
        for (int num : set) {
            if (num > res && num < secondMax) {
                res = num;
            }
        }

        return res;
    }
}
