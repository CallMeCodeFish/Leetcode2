package day5;

/**
 * @author Heng Yu
 * @date 3/1/20 9:37 PM
 */

/**
 * leetcode 60: Permutation Sequence
 */

public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence solution = new PermutationSequence();
        String result = solution.getPermutation(4, 9);
        System.out.println(result);
    }

    public String getPermutation(int n, int k) {
        int range = 1;
        for (int i = 1; i < n; ++i) {
            range *= i;
        }
        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        dfs(n, range, k, visited, sb);
        return sb.toString();
    }

    private void dfs(int n, int range, int k, boolean[] visited, StringBuilder sb) {
        //edge case
        if (n == 1) {
            for (int i = 1; i < visited.length; ++i) {
                if (!visited[i]) {
                    sb.append(i);
                    break;
                }
            }
            return;
        }

        int rank = 0;
        for (int i = 1; i <= n; ++i) {
            if (k <= i * range) {
                k -= (i - 1) * range;
                rank = i;
                break;
            }
        }
        for (int i = 1; i < visited.length; ++i) {
            if (!visited[i]) {
                --rank;
                if (rank == 0) {
                    sb.append(i);
                    visited[i] = true;
                    break;
                }
            }
        }
        dfs(n - 1, range / (n - 1), k, visited, sb);
    }
}
