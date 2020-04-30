package hard;

/**
 * @author Heng Yu
 * @date 4/29/20 7:09 PM
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 407: Trapping rain water II
 */
public class TrapRainWaterII {
    public static void main(String[] args) {
        TrapRainWaterII solution = new TrapRainWaterII();
        int[][] map = {
                {14, 17, 18, 16, 14, 16},
                {17, 3, 10, 2, 3, 8},
                {11, 10, 4, 7, 1, 7},
                {13, 7, 2, 9, 8, 10},
                {13, 1, 3, 4, 8, 6},
                {20, 3, 3, 9, 10, 8}
        };

//        int[][] map = {
//                {1,4,3,1,3,2},
//                {3,2,1,3,2,4},
//                {2,3,3,2,3,1}
//        };
        int result = solution.trapRainWater(map);
        System.out.println(result);
    }

    private static class Cell {
        int x;
        int y;
        int h;

        public Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        PriorityQueue<Cell> heap = new PriorityQueue<>(m + n, (o1, o2) -> o1.h - o2.h);

        for (int i = 0; i < m; ++i) {
            visited[i][0] = true;
            heap.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][n - 1] = true;
            heap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        for (int j = 0; j < n; ++j) {
            visited[0][j] = true;
            heap.offer(new Cell(0, j, heightMap[0][j]));
            visited[m - 1][j] = true;
            heap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
        }

        int res = 0;

        while (!heap.isEmpty()) {
            Cell poll = heap.poll();
            for (int[] dir : dirs) {
                int nx = poll.x + dir[0];
                int ny = poll.y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (heightMap[nx][ny] < poll.h) {
                        res += poll.h - heightMap[nx][ny];
                    }
                    heap.offer(new Cell(nx, ny, Math.max(poll.h, heightMap[nx][ny])));
                }
            }
        }

        return res;
    }
}
