package newquestion.day8;

/**
 * @author Heng Yu
 * @date 5/5/20 7:54 PM
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 994: Rotting Oranges
 */
public class RottingOranges {
    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }

        if (q.isEmpty()) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == 1) return -1;
                }
            }
            return 0;
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = -1;

        while (!q.isEmpty()) {
            ++res;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Pair poll = q.poll();
                for (int[] dir : dirs) {
                    int x = poll.x + dir[0];
                    int y = poll.y + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        q.offer(new Pair(x, y));
                    }
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return res;
    }
}
