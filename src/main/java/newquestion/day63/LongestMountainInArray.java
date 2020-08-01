package newquestion.day63;

/**
 * @author Heng Yu
 * @date 7/31/20 4:05 PM
 */

/**
 * leetcode 845: Longest mountain in array
 */
public class LongestMountainInArray {
    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;

        int res = 0;
        boolean findPeak = false;

        int i = 0, j = 1;
        while (j < A.length) {
            if (!findPeak) {
                if (A[j - 1] == A[j]) {
                    i = j;
                } else if (A[j - 1] > A[j]) {
                    if (i == j - 1) {
                        i = j;
                    } else {
                        findPeak = true;
                    }
                }
            } else {
                if (A[j - 1] <= A[j]) {
                    int cur = j - i;
                    res = Math.max(res, cur);
                    findPeak = false;
                    i = --j;
                }
            }
            j++;
        }

        if (findPeak) res = Math.max(res, j - i);


        return res;
    }
}
