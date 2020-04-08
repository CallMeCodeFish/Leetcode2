package day31;

/**
 * @author Heng Yu
 * @date 4/7/20 5:53 PM
 */

/**
 * leetcode 365: Water and Jug Problem
 */

public class WaterAndJugProblem {
    public boolean canMeasureWater(int x, int y, int z) {
        //edge case
        if (z > x + y) return false;
        if (z == 0 || x != 0 && z % x == 0 || y != 0 && z % y == 0 || x + y != 0 && z % (x + y) == 0) return true;

        int big = 0, small = 0;
        if (x < y) {
            big = y;
            small = x;
        } else {
            big = x;
            small = y;
        }
        for (long i = 1; i <= big; ++i) {
            long num = i * small % big;
            if (z == num || z == num + small) return true;
        }
        return false;
    }
}
