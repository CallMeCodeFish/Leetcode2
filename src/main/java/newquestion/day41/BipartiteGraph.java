package newquestion.day41;

/**
 * @author Heng Yu
 * @date 6/22/20 6:10 PM
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * leetcode 785: Is graph bipartite
 */
public class BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        Set<Integer>[] sets = new Set[2];

        sets[0] = new HashSet<>();
        sets[1] = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();

        for (int n = 0; n < graph.length; n++) {
            if (!sets[0].contains(n) && !sets[1].contains(n) && graph[n].length != 0) {
                sets[0].add(n);
                q.offer(n);
                int i = 1;

                while (!q.isEmpty()) {
                    int size = q.size();
                    int j = (i + 1) % 2;
                    Set<Integer> include = sets[i];
                    Set<Integer> exclude = sets[j];

                    for (int k = 0; k < size; k++) {
                        int cur = q.poll();
                        int[] neighbors = graph[cur];
                        for (int next : neighbors) {
                            if (exclude.contains(next)) return false;
                            if (!include.contains(next)) {
                                include.add(next);
                                q.offer(next);
                            }
                        }
                    }

                    i = j;
                }
            }
        }

        return true;
    }
}
