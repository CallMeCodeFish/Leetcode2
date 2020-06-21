package newquestion.day39;

import java.util.*;

/**
 * @author Heng Yu
 * @date 6/20/20 7:47 PM
 */

/**
 * leetcode 815 Bus routes
 * solution: BFS
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int r : routes[i]) {
                Set<Integer> set = map.getOrDefault(r, new HashSet<>());
                set.add(i);
                map.put(r, set);
            }
        }

        if (!map.containsKey(S) || !map.containsKey(T)) return -1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(S);
        Set<Integer> visitedStations = new HashSet<>();
        visitedStations.add(S);
        Set<Integer> visitedBuses = new HashSet<>();
        int res = 1;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                int from = q.poll();
                Set<Integer> buses = map.get(from);
                for (int bus : buses) {
                    if (!visitedBuses.contains(bus)) {
                        visitedBuses.add(bus);
                        int[] route = routes[bus];
                        for (int r : route) {
                            if (!visitedStations.contains(r)) {
                                if (r == T) return res;
                                visitedStations.add(r);
                                q.offer(r);
                            }
                        }
                    }
                }
            }

            res++;
        }

        return -1;
    }
}
