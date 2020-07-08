package newquestion.day50;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 7/7/20 10:12 PM
 */

/**
 * leetcode 296: Best meeting point
 * solution: BFS or tricky
 * ref: 5ms answer
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) rows.add(i);
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) cols.add(j);
            }
        }

        int res = 0;

        res += calculate(rows);
        res += calculate(cols);

        return res;
    }

    private int calculate(List<Integer> list) {
        int res = 0;
        int i = 0, j = list.size() - 1;

        while (i <= j) {
            res += list.get(j) - list.get(i);
            i++;
            j--;
        }

        return res;
    }

    public int minTotalDistance1(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;

        List<int[]> list = new ArrayList<>();

        int tx = 0, ty = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    tx += i;
                    ty += j;
                    list.add(new int[]{i, j});
                }
            }
        }

        int size = list.size();

        int x = tx / size;
        int y = ty / size;

        int res = 0;
        for (int[] p : list) {
            res += Math.abs(p[0] - x) + Math.abs(p[1] - y);
        }

        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (true) {
            boolean canFind = false;

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    int cur = 0;
                    for (int[] p : list) {
                        cur += Math.abs(p[0] - nx) + Math.abs(p[1] - ny);
                    }
                    if (cur < res) {
                        canFind = true;
                        x = nx;
                        y = ny;
                        res = cur;
                    }
                }
            }

            if (!canFind) break;
        }

        return res;
    }
}
