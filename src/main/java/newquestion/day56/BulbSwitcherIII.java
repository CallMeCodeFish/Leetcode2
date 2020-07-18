package newquestion.day56;

/**
 * @author Heng Yu
 * @date 7/18/20 5:01 PM
 */


public class BulbSwitcherIII {
    public int numTimesAllBlue(int[] light) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(max, light[i]);
            if (max == i + 1) res++;
        }
        return res;
    }
}
