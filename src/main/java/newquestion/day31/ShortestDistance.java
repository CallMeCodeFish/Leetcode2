package newquestion.day31;

/**
 * @author Heng Yu
 * @date 6/8/20 4:35 PM
 */

import java.util.*;

/**
 * leetcode 317: Shortest distance from all buildings
 */
public class ShortestDistance {
    public static void main(String[] args) {
        ShortestDistance solution = new ShortestDistance();
        int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        int result = solution.shortestDistance(grid);
        System.out.println(result);
    }

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) total++;
            }
        }

        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        // pruning
        prune:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(grid, i, j, dirs);
                    if (count != total) return -1;
                    break prune;
                }
            }
        }

        long res = Long.MAX_VALUE;

        // bfs
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -3) {
                    int sum = 0;
                    int cur = 1;
                    int count = 0;
                    Set<String> seen = new HashSet<>();
                    Queue<int[]> q = new LinkedList<>();
                    int[] center = {i, j};
                    seen.add(Arrays.toString(center));
                    q.offer(center);

                    boolean canBreak = false;
                    while (!q.isEmpty()) {
                        int size = q.size();
                        for (int k = 0; k < size; k++) {
                            int[] point = q.poll();
                            int x = point[0];
                            int y = point[1];

                            for (int[] dir : dirs) {
                                int nx = x + dir[0];
                                int ny = y + dir[1];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] < 0) {
                                    int[] next = {nx, ny};
                                    String s = Arrays.toString(next);
                                    if (!seen.contains(s)) {
                                        if (grid[nx][ny] == -1) {
                                            sum += cur;
                                            if (++count == total) {
                                                canBreak = true;
                                                break;
                                            }
                                        } else {
                                            q.offer(next);
                                        }
                                        seen.add(s);
                                    }
                                }
                            }

                            if (canBreak) break;
                        }
                        if (canBreak) break;
                        cur++;
                    }

                    if (count == total) res = Math.min(res, sum);
                }
            }
        }

        return (res == Long.MAX_VALUE)? -1 : (int) res;
    }

    private int dfs(int[][] grid, int i, int j, int[][] dirs) {
        int res = 0;

        if (grid[i][j] == 1) {
            grid[i][j] = -1;
            res++;
        } else {
            grid[i][j] = -3;
        }

        int m = grid.length;
        int n = grid[0].length;

        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n && (grid[ni][nj] == 0 || grid[ni][nj] == 1)) {
                res += dfs(grid, ni, nj, dirs);
            }
        }

        return res;
    }
}
