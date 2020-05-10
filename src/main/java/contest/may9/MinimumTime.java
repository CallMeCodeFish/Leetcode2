package contest.may9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 5/9/20 10:43 PM
 */


public class MinimumTime {
    public static void main(String[] args) {
        MinimumTime solution = new MinimumTime();
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        int result = solution.minTime(7, edges, Arrays.asList(false, false, true, false, true, true, false));
        System.out.println(result);
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Set<Integer>[] matrix = new Set[n];
        for (int i = 0; i < n; ++i) {
            matrix[i] = new HashSet<>();
        }

        for (int[] e : edges) {
            int n1 = e[0];
            int n2 = e[1];
            matrix[n1].add(n2);
            matrix[n2].add(n1);
        }

        return dfs(0, matrix, hasApple);
    }

    private int dfs(int cur, Set<Integer>[] matrix, List<Boolean> hasApple) {
        int res = 0;

        Set<Integer> children = matrix[cur];
        for (int child : children) {
            matrix[child].remove(cur);
            res += dfs(child, matrix, hasApple);
        }

        if (cur != 0 && (res != 0 || hasApple.get(cur))) res += 2;

        return res;
    }
}
