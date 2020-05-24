package newquestion.day20;

/**
 * @author Heng Yu
 * @date 5/23/20 3:49 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 1086: High five
 */
public class HighFive {
    public int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> scores = new HashMap<>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!scores.containsKey(id)) scores.put(id, new ArrayList<>());
            scores.get(id).add(score);
        }

        int[][] res = new int[scores.size()][2];

        for (int id : scores.keySet()) {
            res[id - 1][0] = id;
            List<Integer> list = scores.get(id);
            list.sort((a, b) -> b - a);
            int sum = 0;
            for (int i = 0; i < 5; ++i) {
                sum += list.get(i);
            }
            res[id - 1][1] = sum / 5;
        }

        return res;
    }
}
