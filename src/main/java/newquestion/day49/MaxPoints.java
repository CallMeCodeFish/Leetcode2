package newquestion.day49;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 7/6/20 8:56 PM
 */

/**
 * leetcode 149: Max points on a line (hard)
 */
public class MaxPoints {
    public int maxPoints(int[][] points) {
        int len = points.length;
        if (len < 3) return len;

        int res = 0;

        Set<Integer> h = new HashSet<>(); //x coordinates
        Set<Integer> v = new HashSet<>(); //y coordinates

        for (int i = 0; i < len; i++) {
            Set<Double> s = new HashSet<>(); //slope
            int[] p1 = points[i];

            if (!v.contains(p1[1])) {
                v.add(p1[1]);
                int count = 0;
                for (int j = i; j < len; j++) {
                    int[] p2 = points[j];
                    if (p2[1] == p1[1]) count++;
                }
                res = Math.max(res, count);
            }

            if (!h.contains(p1[0])) {
                v.add(p1[0]);
                int count = 0;
                for (int j = i; j < len; j++) {
                    int[] p2 = points[j];
                    if (p2[0] == p1[0]) count++;
                }
                res = Math.max(res, count);
            }

            for (int j = i + 1; j < len; j++) {
                int[] p2 = points[j];
                if (p2[0] != p1[0] && p2[1] != p1[1]) {
                    double slope = (double) (p2[1] - p1[1]) / (p2[0] - p1[0]);
                    if (!s.contains(slope)) {
                        int count = 0;

                        for (int k = 0; k < len; k++) {
                            if (isOn(p1, p2, points[k])) {
                                count++;
                            }
                        }

                        res = Math.max(res, count);
                    }
                }
            }
        }

        return res;
    }

    private boolean isOn(int[] p1, int[] p2, int[] p) {
        long num1 = (long) (p2[1] - p1[1]) * (p[0] - p1[0]);
        long num2 = (long) (p2[0] - p1[0]) * (p[1] - p1[1]);
        return num1 == num2;
    }
}
