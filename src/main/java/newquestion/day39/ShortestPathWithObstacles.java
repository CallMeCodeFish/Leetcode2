package newquestion.day39;

import java.util.*;

/**
 * @author Heng Yu
 * @date 6/20/20 9:34 PM
 */

/**
 * leetcode 1293: Shortest path in a grid with obstacles elimination
 * solution: BFS
 * ref: https://www.bilibili.com/video/BV1KJ411s7qu?from=search&seid=11516308895343339177
 */
public class ShortestPathWithObstacles {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] obstacles = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(obstacles[i], Integer.MAX_VALUE);
        }

        obstacles[0][0] = 0;

        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, 0});

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int x = poll[0];
                int y = poll[1];

                if (x == m - 1 && y == n - 1) return steps;

                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        int no = poll[2] + grid[nx][ny];
                        if (no <= k && no < obstacles[nx][ny]) {
                            obstacles[nx][ny] = no;
                            q.offer(new int[]{nx, ny, no});
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}
