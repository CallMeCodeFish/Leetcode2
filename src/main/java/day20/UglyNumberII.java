package day20;

/**
 * @author Heng Yu
 * @date 3/17/20 8:34 PM
 */

/**
 * leetcode 264: Ugly Number II
 */

public class UglyNumberII {
    public static void main(String[] args) {
        UglyNumberII solution = new UglyNumberII();
        int result = solution.nthUglyNumber(10);
        System.out.println(result);
    }

    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int two = 0;
        int three = 0;
        int five = 0;
        int i = 1;
        while (i < n) {
            int prod2 = res[two] * 2;
            int prod3 = res[three] * 3;
            int prod5 = res[five] * 5;
            int min = Math.min(prod2, Math.min(prod3, prod5));
            if (prod2 == min) {
                ++two;
            } else if (prod3 == min) {
                ++three;
            } else {
                ++five;
            }
            if (res[i - 1] < min) res[i++] = min;
        }
        return res[n - 1];
    }
}
