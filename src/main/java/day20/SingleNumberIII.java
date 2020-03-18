package day20;

/**
 * @author Heng Yu
 * @date 3/17/20 5:18 PM
 */

/**
 * leetcode 260: Single Number III
 */

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int shift = 0;
        while (shift < 32) {
            if ((xor >> shift & 1) == 1) {
                break;
            }
            ++shift;
        }
        for (int num : nums) {
            if ((num >> shift & 1) == 1) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
