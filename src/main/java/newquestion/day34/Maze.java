package newquestion.day34;

/**
 * @author Heng Yu
 * @date 6/11/20 5:55 PM
 */

import java.util.*;

/**
 * leetcode 490: The maze
 */
public class Maze {
    public static void main(String[] args) {
        Maze solution = new Maze();
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] end = {1,2};
        boolean result = solution.hasPath(maze, start, end);
        System.out.println(result);
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;

        // check if there is a wall besides the destination
        int dx = destination[0], dy = destination[1];
        if (dx > 0 && maze[dx - 1][dy] == 0 && dx < m - 1 && maze[dx + 1][dy] == 0 && dy > 0 && maze[dx][dy - 1] == 0 && dy < n - 1 && maze[dx][dy + 1] == 0) return false;

        // check if the start and the destination are the same
        if (start[0] == dx && start[1] == dy) return true;

        // bfs
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(start);

        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            for (int[] dir : dirs) {
                int nx = x;
                int ny = y;
                while (nx + dir[0] >= 0 && nx + dir[0] < m && ny + dir[1] >= 0 && ny + dir[1] < n && maze[nx + dir[0]][ny + dir[1]] != 1) {
                    nx += dir[0];
                    ny += dir[1];
                }
                if (!visited[nx][ny]) {
                    if (nx == dx && ny == dy) return true;
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}
