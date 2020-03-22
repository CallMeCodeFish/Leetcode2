package day24;

import java.util.*;

/**
 * @author Heng Yu
 * @date 3/21/20 6:39 PM
 */


public class MinimumHeightTrees {
    public static void main(String[] args) {
        MinimumHeightTrees solution = new MinimumHeightTrees();
//        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
//        List<Integer> result = solution.findMinHeightTrees(4, edges);
        int[][] edges = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        List<Integer> result = solution.findMinHeightTrees(6, edges);
        System.out.println(result);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        //edge case
        if (n == 0) return res;
        if (n == 1) {
            res.add(0);
            return res;
        }

        Set<Integer>[] matrix = new Set[n];
        for (int i = 0; i < n; ++i) {
            matrix[i] = new HashSet<>();
        }
        for (int[] e : edges) {
            int first = e[0];
            int second = e[1];
            matrix[first].add(second);
            matrix[second].add(first);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (matrix[i].size() == 1) q.offer(i);
        }
        while (n > 2) {
            int size = q.size();
            n -= size;
            for (int i = 0; i < size; ++i) {
                int cur = q.poll();
                Set<Integer> neighbors = matrix[cur];
                for (int next : neighbors) {
                    matrix[next].remove(cur);
                    if (matrix[next].size() == 1) q.offer(next);
                }
            }
        }
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }
}
