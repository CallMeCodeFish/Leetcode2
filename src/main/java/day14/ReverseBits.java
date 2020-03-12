package day14;

/**
 * @author Heng Yu
 * @date 3/11/20 5:19 PM
 */

import java.util.Map;

/**
 * leetcode 190: Reverse Bits
 */

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int i = 0;
        int res = 0;
        while (i < 32) {
            int digit = n >>> i & 1;
            res += digit << (31 - i);
            ++i;
        }
        return res;
    }
}
