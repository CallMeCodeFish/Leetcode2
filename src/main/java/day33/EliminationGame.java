package day33;

/**
 * @author Heng Yu
 * @date 4/9/20 7:17 PM
 */

/**
 * leetcode 390: Elimination Game
 */

public class EliminationGame {
    public static void main(String[] args) {
        EliminationGame solution = new EliminationGame();
        int result = solution.lastRemaining(10);
        System.out.println(result);
    }

    public int lastRemaining(int n) {
        return helper(n, true);
    }

    private int helper(int n, boolean fromLeft) {
        //edge case
        if (n == 1) return 1;
        if (fromLeft) {
            return 2 * helper(n / 2, false);
        } else {
            if (n % 2 == 1) {
                return 2 * helper(n / 2, true);
            } else {
                return 2 * helper(n / 2, true) - 1;
            }
        }
    }
}
