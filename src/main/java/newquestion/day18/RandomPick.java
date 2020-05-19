package newquestion.day18;

/**
 * @author Heng Yu
 * @date 5/18/20 4:30 PM
 */

import java.util.Random;

/**
 * leetcode 528: Random pick with weight
 */
public class RandomPick {
    private int[] cumulative;
    private Random rand;

    public RandomPick(int[] w) {
        rand = new Random(System.currentTimeMillis());
        int len = w.length;
        cumulative = new int[len];
        cumulative[0] = w[0];
        for (int i = 1; i < len; ++i) {
            cumulative[i] = cumulative[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int max = cumulative[cumulative.length - 1];
        int target = rand.nextInt(max);
        return binSearch(target);
    }

    private int binSearch(int target) {
        int l = 0, r = cumulative.length;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (cumulative[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
