package day13;

/**
 * @author Heng Yu
 * @date 3/11/20 12:32 AM
 */

/**
 * leetcode 169: Majority Element
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                ++count;
                res = num;
            } else {
                if (num == res) {
                    ++count;
                } else {
                    --count;
                }
            }
        }
        return res;
    }
}
