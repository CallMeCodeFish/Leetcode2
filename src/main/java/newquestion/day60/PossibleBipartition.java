package newquestion.day60;

import java.util.*;

/**
 * @author Heng Yu
 * @date 7/23/20 6:56 PM
 */

/**
 * leetcode 886: Possible bipartition
 * solution: dfs
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length < 2) return true;

        List<Integer>[] matrix = new List[N + 1];
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int[] d : dislikes) {
            matrix[d[0]].add(d[1]);
            matrix[d[1]].add(d[0]);
        }

        Set<Integer>[] sets = new Set[2];
        sets[0] = new HashSet<>();
        sets[1] = new HashSet<>();

        for (int[] d : dislikes) {
            if (!visited[d[0]]) {
                visited[d[0]] = true;
                Queue<Integer> q = new LinkedList<>();
                q.offer(d[0]);
                if (!canPartition(q, matrix, visited, sets, 0, 1)) return false;
            }
        }

        return true;
    }

    private boolean canPartition(Queue<Integer> q, List<Integer>[] matrix, boolean[] visited, Set<Integer>[] sets, int cur, int next) {
        if (q.isEmpty()) return true;

        int size = q.size();
        for (int i = 0; i < size; i++) {
            int poll = q.poll();
            List<Integer> dislike = matrix[poll];
            for (int d : dislike) {
                if (!visited[d]) {
                    visited[d] = true;
                    q.offer(d);
                } else {
                    if (sets[cur].contains(d)) return false;
                }
            }
            sets[cur].add(poll);
        }

        return canPartition(q, matrix, visited, sets, next, cur);
    }
}
