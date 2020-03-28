package day27;

/**
 * @author Heng Yu
 * @date 3/27/20 8:56 PM
 */

import java.util.Arrays;

/**
 * leetcode 338: Counting Bits
 */

public class CountingBits {
    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        int[] result = solution.countBits(5);
        System.out.println(Arrays.toString(result));
    }

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        boolean isEven = false;
        for (int i = 1; i <= num; ++i) {
            if (isEven) {
                res[i] = res[i / 2];
                isEven = false;
            } else {
                res[i] = res[i - 1] + 1;
                isEven = true;
            }
        }
        return res;
    }
}
