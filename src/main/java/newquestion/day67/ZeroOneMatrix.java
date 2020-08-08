package newquestion.day67;


import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 542: 01 matrix
 * solution: dfs
 * ref: https://leetcode.com/problems/01-matrix/discuss/101021/Java-Solution-BFS
 */
public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] res = new int[m][n];

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (res[nx][ny] > res[x][y] + 1) {
                        res[nx][ny] = res[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return res;
    }
}
