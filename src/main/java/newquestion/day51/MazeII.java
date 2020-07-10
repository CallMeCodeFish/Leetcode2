package newquestion.day51;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heng Yu
 * @date 7/9/20 5:17 PM
 */

/**
 * leetcode 505: The maze II
 */
public class MazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int sx = start[0];
        int sy = start[1];

        Queue<int[]> pq = new LinkedList<>();
        Queue<int[]> dq = new LinkedList<>();

        visited[sx][sy] = true;

        for (int[] d : dirs) {
            int nx = sx + d[0];
            int ny = sy + d[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                pq.offer(new int[]{nx, ny});
                dq.offer(d);
            }
        }

        int res = 1;

        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] curP = pq.poll();
                int[] curD = dq.poll();
                int x = curP[0];
                int y = curP[1];
                int nx = x + curD[0];
                int ny = y + curD[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                    pq.offer(new int[]{nx, ny});
                    dq.offer(curD);
                } else {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        if (x == destination[0] && y == destination[1]) return res;
                        for (int[] d : dirs) {
                            nx = x + d[0];
                            ny = y + d[1];
                            if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == 0) {
                                pq.offer(new int[]{nx, ny});
                                dq.offer(d);
                            }
                        }
                    }
                }
            }

            res++;
        }

        return -1;
    }
}
