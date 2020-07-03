package newquestion.day46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 7/2/20 7:27 PM
 */

/**
 * leetcode 969: Pancake sorting
 * ref: https://leetcode.com/problems/pancake-sorting/discuss/214213/JavaC%2B%2BPython-Straight-Forward
 */
public class PancakeSorting {
    public List<Integer> pancakeSort(int[] A) {
        int len = A.length;
        List<Integer> res = new ArrayList<>();

        for (int max = A.length; max > 0; max--) {
            int i = 0;
            while (A[i] != max) i++;
            reverse(A, i + 1);
            res.add(i + 1);
            reverse(A, max);
            res.add(max);
        }

        return res;
    }

    private void reverse(int[] A, int n) {
        int i = 0, j = n - 1;
        while (i <= j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
}
