package day35;

/**
 * @author Heng Yu
 * @date 4/22/20 5:44 PM
 */

/**
 * leetcode 396: Rotate Function
 */
public class RotateFunction {
    public static void main(String[] args) {
        RotateFunction solution = new RotateFunction();
        int[] A = {4, 3, 2, 6};
        int result = solution.maxRotateFunction(A);
        System.out.println(result);
    }

    public int maxRotateFunction(int[] A) {
        //edge case
        if (A == null || A.length == 0) return 0;

        int len = A.length;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            max += i * A[i];
            if (i != len - 1) sum += A[i];
        }
        int cur = max;
        for (int i = len - 1; i > 0; --i) {
            cur = cur + sum - (len - 1) * A[i];
            max = Math.max(max, cur);
            sum = sum + A[i] - A[i - 1];
        }
        return max;
    }
}
