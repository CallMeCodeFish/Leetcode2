package day21;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 3/18/20 8:04 PM
 */

/**
 * leetcode 274: H-Index
 */

public class HIndex {
    public static void main(String[] args) {
        HIndex solution = new HIndex();
        int[] citations = new int[]{0, 1};
        int result = solution.hIndex(citations);
        System.out.println(result);
    }

    public int hIndex(int[] citations) {
        //edge case
        if (citations == null || citations.length == 0) return 0;

        Arrays.sort(citations);
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
