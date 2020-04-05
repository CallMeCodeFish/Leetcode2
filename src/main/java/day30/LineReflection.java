package day30;

/**
 * @author Heng Yu
 * @date 4/4/20 8:54 PM
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 356: Line Reflection
 */

public class LineReflection {
    public static void main(String[] args) {
        LineReflection solution = new LineReflection();
        int[][] points = new int[0][];
        boolean result = solution.isReflected(points);
        System.out.println(result);
    }

    public boolean isReflected(int[][] points) {
        //edge case
        if (points == null || points.length < 2) return true;


        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {

            int x = point[0];
            int y = point[1];
            if (max < x) max = x;
            if (x < min) min = x;
            if (!map.containsKey(x)) {
                map.put(x, new HashSet<>());
            }
            map.get(x).add(y);
        }
        int target = min + max;
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (!map.containsKey(target - x) || !map.get(target - x).contains(y)) return false;
        }
        return true;
    }
}
