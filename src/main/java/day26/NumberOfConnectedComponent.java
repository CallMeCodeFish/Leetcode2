package day26;

/**
 * @author Heng Yu
 * @date 3/24/20 8:08 PM
 */

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 323: Number of Connected Components in an Undirected Graph
 */

public class NumberOfConnectedComponent {
    public static void main(String[] args) {
        NumberOfConnectedComponent solution = new NumberOfConnectedComponent();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}, {2, 3}};
        int result = solution.countComponents(5, edges);
        System.out.println(result);
    }

    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        List<Integer>[] matrix = new List[n];
        for (int i = 0; i < n; ++i) {
            matrix[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int first = e[0];
            int second = e[1];
            matrix[first].add(second);
            matrix[second].add(first);
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                ++res;
                helper(i, matrix, visited);
            }
        }
        return res;
    }

    private void helper(int i, List<Integer>[] matrix, boolean[] visited) {
        //edge case

        visited[i] = true;
        List<Integer> neighbors = matrix[i];
        for (int j : neighbors) {
            if (!visited[j]) helper(j, matrix, visited);
        }
    }
}
