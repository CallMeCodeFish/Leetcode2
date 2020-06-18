package newquestion.day37;

/**
 * @author Heng Yu
 * @date 6/17/20 3:37 PM
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 797: All paths from source to target
 */
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(0, graph, new LinkedList<>(), res);

        return res;
    }

    private void dfs(int node, int[][] graph, List<Integer> list, List<List<Integer>> res) {
        int n = graph.length;

        list.add(node);

        if (node == n - 1) {
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        int[] neighbors = graph[node];

        for (int next : neighbors) {
            dfs(next, graph, list, res);
        }

        list.remove(list.size() - 1);
    }
}
