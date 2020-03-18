package day20;

/**
 * @author Heng Yu
 * @date 3/17/20 5:33 PM
 */

import java.util.*;

/**
 * leetcode 261: Graph Valid Tree
 */

public class GraphValidTree {
    public static void main(String[] args) {
        GraphValidTree solution = new GraphValidTree();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        boolean result = solution.validTree2(5, edges);
        System.out.println(result);
    }

    public boolean validTree(int n, int[][] edges) {
        Set<Integer>[] matrix = new Set[n];
        for (int i = 0; i < n; ++i) {
            matrix[i] = new HashSet<>();
        }
        for (int[] e : edges) {
            matrix[e[0]].add(e[1]);
            matrix[e[1]].add(e[0]);
        }
        boolean[] visited = new boolean[n];
        if (!dfs(0, matrix, visited)) return false;
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private boolean dfs(int i, Set<Integer>[] matrix, boolean[] visited) {
        visited[i] = true;
        Set<Integer> neighbors = matrix[i];
        for (int j : neighbors) {
            matrix[j].remove(i);
            if (visited[j]) return false;
            if (!dfs(j, matrix, visited)) return false;
        }
        return true;
    }

    public boolean validTree2(int n, int[][] edges) {
        if (edges.length + 1 != n) return false;
        int[] counts = new int[n];
        List<Integer>[] matrix = new List[n];
        for (int i = 0; i < n; ++i) {
            matrix[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            ++counts[e[0]];
            ++counts[e[1]];
            matrix[e[0]].add(e[1]);
            matrix[e[1]].add(e[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (counts[i] == 0) return false;
            if (counts[i] == 1) q.offer(i);
        }
        int res = 0;
        while (!q.isEmpty()) {
            int poll = q.poll();
            ++res;
            if (counts[poll] > 0) {
                --counts[poll];
                List<Integer> neighbors = matrix[poll];
                for (int neighbor : neighbors) {
                    if (counts[neighbor] > 0) --counts[neighbor];
                    if (counts[neighbor] == 1) q.offer(neighbor);
                }
            }
        }
        return res == n;
    }
}
