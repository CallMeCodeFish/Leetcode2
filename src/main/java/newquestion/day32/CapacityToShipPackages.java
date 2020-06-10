package newquestion.day32;

/**
 * @author Heng Yu
 * @date 6/9/20 5:54 PM
 */

import java.util.Arrays;

/**
 * leetcode 1011: Capacity to ship packages within D days
 * solution: binary search, dp will cause TLE
 * ref: https://www.youtube.com/watch?v=-F2ysRiSTvk
 */
public class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int d) {
        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValid(weights, d, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isValid(int[] weights, int d, int capacity) {
        int count = 0;
        int i = 0;
        while (i < weights.length) {
            int sum = 0;
            int j = i;
            while (j < weights.length && sum + weights[j] <= capacity) {
                sum += weights[j];
                j++;
            }

            if (++count > d) return false;

            i = j;
        }

        return true;
    }
}
