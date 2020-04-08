package day31;

/**
 * @author Heng Yu
 * @date 4/7/20 9:39 PM
 */

/**
 * leetcode 370: Range Addition
 */

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1] + 1;
            int inc = update[2];
            res[start] += inc;
            if (end < length) {
                res[end] -= inc;
            }
        }
        for (int i = 1; i < length; ++i) {
            res[i] += res[i - 1];
        }
        return res;
    }
}
