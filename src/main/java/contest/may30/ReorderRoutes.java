package contest.may30;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/30/20 10:56 PM
 */


public class ReorderRoutes {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> froms = new HashMap<>();
        Map<Integer, List<Integer>> tos = new HashMap<>();

        boolean[] visited = new boolean[n];

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            froms.putIfAbsent(from, new ArrayList<>());
            froms.get(from).add(to);
            tos.putIfAbsent(to, new ArrayList<>());
            tos.get(to).add(from);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                visited[cur] = true;
                List<Integer> fromCurrent = froms.get(cur);
                List<Integer> toCurrent = tos.get(cur);
                if (fromCurrent != null) {
                    for (int to : fromCurrent) {
                        if (!visited[to]) {
                            res++;
                            q.offer(to);
                        }
                    }
                }

                if (toCurrent != null) {
                    for (int from : toCurrent) {
                        if (!visited[from]) q.offer(from);
                    }
                }
            }
        }

        return res;
    }
}
