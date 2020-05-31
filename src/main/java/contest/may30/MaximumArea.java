package contest.may30;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 5/30/20 10:35 PM
 */


public class MaximumArea {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) { //755332975
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        final int MODULO = 1000_000_000 + 7;

        int maxHeight = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxHeight = Math.max(maxHeight, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        maxHeight = Math.max(maxHeight, h - horizontalCuts[horizontalCuts.length - 1]);

        int maxWidth = verticalCuts[0];
        for (int i = 1; i < verticalCuts.length; i++) {
            maxWidth = Math.max(maxWidth, verticalCuts[i] - verticalCuts[i - 1]);
        }
        maxWidth = Math.max(maxWidth, w - verticalCuts[verticalCuts.length - 1]);

        long res = ((long) maxHeight * maxWidth) % MODULO;

        return (int) res;
    }
}
