package day11;

/**
 * @author Heng Yu
 * @date 3/7/20 3:06 PM
 */

/**
 * leetcode 136: Single Number
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
