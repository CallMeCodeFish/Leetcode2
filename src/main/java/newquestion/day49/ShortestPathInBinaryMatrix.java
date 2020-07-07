package newquestion.day49;

/**
 * @author Heng Yu
 * @date 7/6/20 4:49 PM
 */

/**
 * leetcode 1091: Shortest path in binary matrix
 * solution: bfs
 */
public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;


        if (n == 1) return 1;

        int res = 2;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

        boolean canFind = false;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int[] start = {0, 0};
        q.offer(start);
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                for (int[] d : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] == 0) {
                        if (nx == n - 1 && ny == n - 1) {
                            canFind = true;
                            break;
                        }
                        int[] next = {nx, ny};
                        visited[nx][ny] = true;
                        q.offer(next);
                    }
                }
                if (canFind) break;
            }

            if (canFind) break;

            res++;
        }

        return canFind ? res : -1;
    }
}
