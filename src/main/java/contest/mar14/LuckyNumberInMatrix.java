package contest.mar14;

/**
 * @author Heng Yu
 * @date 3/14/20 10:30 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 1380: Lucky Number in a Matrix
 */

public class LuckyNumberInMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int min = Integer.MAX_VALUE;
            int minRow = -1;
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minRow = j;
                }
            }
            int max = min;
            if (map.containsKey(minRow)) {
                max = map.get(minRow);
            } else {
                for (int j = 0; j < m; ++j) {
                    max = Math.max(max, matrix[j][minRow]);
                }
                map.put(minRow, max);
            }
            if (max == min) res.add(min);
        }
        return res;
    }
}
