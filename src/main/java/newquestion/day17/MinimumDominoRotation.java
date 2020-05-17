package newquestion.day17;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 5/16/20 3:59 PM
 */

/**
 * leetcode 1007: Minimum domino rotations for equal row
 */
public class MinimumDominoRotation {
    public static void main(String[] args) {
        MinimumDominoRotation solution = new MinimumDominoRotation();
        int[] A = {2,1,2,4,2,2};
        int[] B = {5,2,6,2,3,2};
        int result = solution.minDominoRotations(A, B);
        System.out.println(result);
    }

    public int minDominoRotations(int[] A, int[] B) {
        boolean[] values = new boolean[7];
        Arrays.fill(values, true);
        int len = A.length;

        for (int i = 1; i < 7; ++i) {
            for (int j = 0; j < len; ++j) {
                if (A[j] != i && B[j] != i) {
                    values[i] = false;
                    break;
                }
            }
        }

        boolean flag = false;
        for (int i = 1; i < values.length; ++i) {
            if (values[i]) {
                flag = true;
                break;
            }
        }

        if (!flag) return -1;

        int[] countA = new int[7];
        int[] countB = new int[7];

        for (int i = 0; i < len; ++i) {
            ++countA[A[i]];
            ++countB[B[i]];
        }

        int res = Integer.MAX_VALUE;

        for (int i = 1; i < values.length; ++i) {
            if (values[i]) {
                int min = len - Math.max(countA[i], countB[i]);
                res = Math.min(res, min);
            }
        }

        return res;
    }
}
