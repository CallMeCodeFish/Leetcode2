package newquestion.day43;

import java.util.*;

/**
 * @author Heng Yu
 * @date 6/27/20 6:32 PM
 */

/**
 * leetcode 939: Minimum area rectangle
 */
public class MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        int res = Integer.MAX_VALUE;
        boolean canFind = false;

        Map<Integer, List<Integer>> vertical = new HashMap<>();
        Map<Integer, Set<Integer>> horizontal = new HashMap<>();

        for (int[] p : points) {
            int x = p[0], y = p[1];
            Set<Integer> h = horizontal.getOrDefault(x, new HashSet<>());
            h.add(y);
            horizontal.put(x, h);

            List<Integer> v = vertical.getOrDefault(y, new ArrayList<>());
            v.add(x);
            vertical.put(y, v);
        }

        for (int y1 : vertical.keySet()) {
            List<Integer> list = vertical.get(y1);
            for (int i = 0; i < list.size(); i++) {
                int x1 = list.get(i);
                Set<Integer> set1 = horizontal.get(x1);
                if (set1.size() > 1) {
                    for (int j = i + 1; j < list.size(); j++) {
                        int x2 = list.get(j);
                        Set<Integer> set2 = horizontal.get(x2);
                        if (set2.size() > 1) {
                            for (int y2 : set1) {
                                if (y2 != y1) {
                                    if (set2.contains(y2)) {
                                        int area = Math.abs(x2 - x1) * Math.abs(y2 - y1);
                                        canFind = true;
                                        res = Math.min(res, area);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return canFind ? res : 0;
    }
}
