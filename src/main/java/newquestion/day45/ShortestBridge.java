package newquestion.day45;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heng Yu
 * @date 6/29/20 2:36 PM
 */

/**
 * leetcode 934: Shortest bridge
 */
public class ShortestBridge {
    public int shortestBridge(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            boolean canBreak = false;
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    findBorder(A, i, j, visited, dirs, q);
                    canBreak = true;
                    break;
                }
            }

            if (canBreak) break;
        }

        //BFS
        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for (int[] d : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                        if (A[nx][ny] == 0) {
                            visited[nx][ny] = true;
                            q.offer(new int[]{nx, ny});
                        } else {
                            return res;
                        }
                    }
                }
            }

            res++;
        }

        return Integer.MAX_VALUE;
    }

    private void findBorder(int[][] A, int i, int j, boolean[][] visited, int[][] dirs, Queue<int[]> q) {
        int m = A.length;
        int n = A[0].length;

        visited[i][j] = true;
        boolean isBorder = false;

        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && A[ni][nj] == 1) {
                if (!visited[ni][nj]) {
                    findBorder(A, ni, nj, visited, dirs, q);
                }
            } else {
                isBorder = true;
            }
        }

        if (isBorder) {
            q.offer(new int[]{i, j});
        }
    }
}
