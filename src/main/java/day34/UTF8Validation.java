package day34;

/**
 * @author Heng Yu
 * @date 4/21/20 9:50 PM
 */

/**
 * leetcode 393: UTF-8 Validation
 */
public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        //edge case
        if (data == null || data.length == 0) return true;

        int i = 0;
        while (i < data.length) {
            int num = data[i];
            if (num <= 0b0_1111111) {
                ++i;
            } else if (0b110_00000 <= num && num <= 0b110_11111) {
                ++i;
                if (i == data.length) return false;
                num = data[i];
                if (num < 0b10_000000 || num > 0b10_111111) return false;
                ++i;
            } else if (0b1110_0000 <= num && num <= 0b1110_1111) {
                for (int j = 0; j < 2; ++j) {
                    ++i;
                    if (i == data.length || data[i] < 0b10_000000 || data[i] > 0b10_111111) return false;
                }
                ++i;
            } else if (0b11110_000 <= num && num <= 0b11110_111) {
                for (int j = 0; j < 3; ++j) {
                    ++i;
                    if (i == data.length || data[i] < 0b10_000000 || data[i] > 0b10_111111) return false;
                }
                ++i;
            } else {
                return false;
            }
        }
        return true;
    }
}
