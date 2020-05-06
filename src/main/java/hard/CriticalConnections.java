package hard;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/4/20 8:17 PM
 */

/**
 * leetcode 1192: Critical connections in a network
 */
public class CriticalConnections {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] visited = new boolean[n];
        int[] discoverTime = new int[n];
        int[] backTime = new int[n];

        List<Integer>[] matrix = new List[n];
        for (int i = 0; i < n; ++i) {
            matrix[i] = new ArrayList<>();
        }

        for (List<Integer> connection : connections) {
            int first = connection.get(0);
            int second = connection.get(1);
            matrix[first].add(second);
            matrix[second].add(first);
        }

        int[] time = {0};

        List<List<Integer>> res = new ArrayList<>();

        helper(0, -1, matrix, visited, discoverTime, backTime, time, res);

        return res;
    }

    private void helper(int cur, int parent, List<Integer>[] matrix, boolean[] visited, int[] discoverTime, int[] backTime, int[] time, List<List<Integer>> res) {
        visited[cur] = true;
        discoverTime[cur] = backTime[cur] = time[0]++;
        List<Integer> neighbors = matrix[cur];
        for (int next : neighbors) {
            if (next != parent) {
                if (!visited[next]) {
                    helper(next, cur, matrix, visited, discoverTime, backTime, time, res);
                    if (discoverTime[cur] < backTime[next]) {
                        res.add(Arrays.asList(cur, next));
                    }
                    backTime[cur] = Math.min(backTime[cur], backTime[next]);
                } else {
                    backTime[cur] = Math.min(backTime[cur], discoverTime[next]);
                }
            }
        }
    }
}
