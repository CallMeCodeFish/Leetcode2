package day11;

/**
 * @author Heng Yu
 * @date 3/7/20 3:10 PM
 */

/**
 * leetcode 137: Single Number II
 */

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int sum = 0;
            for (int num : nums) {
                sum += num >> i & 1;
            }
            res += (sum % 3) << i;
        }
        return res;
    }
}
