package newquestion.day29;

/**
 * @author Heng Yu
 * @date 6/4/20 2:58 PM
 */

/**
 * leetcode 329: Longest increasing path in a matrix
 * Solution: dfs + memorization
 */
public class LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] memo = new int[m][n];
        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j] == 0) {
                    int cur = dfs(matrix, i, j, memo, dirs);
                    res = Math.max(res, cur);
                }
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo, int[][] dirs) {
        if (memo[i][j] > 0) return memo[i][j];

        int m = matrix.length;
        int n = matrix[0].length;

        int res = 0;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && matrix[i][j] < matrix[ni][nj]) {
                int cur = dfs(matrix, ni, nj, memo, dirs);
                res = Math.max(res, cur);
            }
        }

        res++;
        memo[i][j] = res;

        return res;
    }
}
