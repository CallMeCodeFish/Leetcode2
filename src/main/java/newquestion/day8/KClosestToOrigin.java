package newquestion.day8;

/**
 * @author Heng Yu
 * @date 5/5/20 9:35 PM
 */

import java.util.PriorityQueue;

/**
 * leetcode 973: K closest points to origin
 */
public class KClosestToOrigin {
    private static class Point {
        int x;
        int y;
        int d;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.d = x * x + y * y;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        int[][] res = new int[K][];

        PriorityQueue<Point> heap = new PriorityQueue<>(K, (a, b) -> a.d - b.d);

        for (int[] point : points) {
            heap.offer(new Point(point[0], point[1]));
        }

        for (int i = 0; i < K; ++i) {
            Point point = heap.poll();
            res[i] = new int[]{point.x, point.y};
        }

        return res;
    }
}
