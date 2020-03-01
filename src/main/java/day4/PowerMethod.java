package day4;

/**
 * @author Heng Yu
 * @date 2/29/20 7:48 PM
 */

/**
 * leetcode 50: Pow(x, n)
 */

public class PowerMethod {
    public static void main(String[] args) {
        PowerMethod solution = new PowerMethod();
        double result = solution.myPow(2.0, Integer.MIN_VALUE);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        //edge case
        if (n == 0) return 1;
        if (x == 0 && n < 0) return Double.POSITIVE_INFINITY;
        if (x == 1) return 1;
        if (x == -1 && n % 2 == 0) return 1;
        if (x == -1 && n % 2 == 1) return -1;

        if (n > 0) {
            return dfs(x, n);
        } else {
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
            } else {
                n = -n;
            }
            return 1 / dfs(x, n);
        }
    }

    private double dfs(double x, int n) {
        //edge case
        if (n == 0) return 1;

        if (n % 2 == 0) {
            return dfs(x * x, n / 2);
        } else {
            return x * dfs(x * x, (n - 1) / 2);
        }
    }
}
