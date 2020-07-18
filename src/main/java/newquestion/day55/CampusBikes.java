package newquestion.day55;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 7/17/20 6:31 PM
 */

/**
 * leetcode 1057: Campus bikes
 * solution: bucket sorting
 * ref: https://www.youtube.com/watch?v=R5OzU68vTKs
 */
public class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int m = workers.length;
        int n = bikes.length;

        List<int[]>[] buckets = new List[2001];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < n; j++) {
                int[] bike = bikes[j];
                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                buckets[dist].add(new int[]{i, j});
            }
        }

        int[] res = new int[m];

        boolean[] seenWorkers = new boolean[m];
        boolean[] seenBikes = new boolean[n];

        for (List<int[]> bucket : buckets) {
            for (int[] pair : bucket) {
                int i = pair[0];
                int j = pair[1];
                if (!seenWorkers[i] && !seenBikes[j]) {
                    seenWorkers[i] = seenBikes[j] = true;
                    res[i] = j;
                }
            }
        }

        return res;
    }
}
