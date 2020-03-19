package day21;

/**
 * @author Heng Yu
 * @date 3/18/20 9:28 PM
 */

/**
 * leetcode 275: H-Index II
 */

public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        int res = 0;
        int length = citations.length;
        for (int i = length - 1; i >= 0; --i) {
            if (length - i <= citations[i]) {
                ++res;
            } else {
                break;
            }
        }
        return res;
    }
}
