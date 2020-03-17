package day19;

/**
 * @author Heng Yu
 * @date 3/17/20 12:17 AM
 */

/**
 * leetcode 256: Paint House
 */

public class PaintHouse {
    public int minCost(int[][] costs) {
        int red = 0;
        int blue = 0;
        int green = 0;
        for (int[] cost : costs) {
            int copyRed = red;
            int copyBlue = blue;
            int copyGreen = green;
            red = cost[0] + Math.min(copyBlue, copyGreen);
            blue = cost[1] + Math.min(copyRed, copyGreen);
            green = cost[2] + Math.min(copyRed, copyBlue);
        }
        return Math.min(red, Math.min(blue, green));
    }
}
