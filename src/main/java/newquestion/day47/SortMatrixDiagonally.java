package newquestion.day47;

import java.util.PriorityQueue;

/**
 * @author Heng Yu
 * @date 7/3/20 4:12 PM
 */

/**
 * leetcode 1329: Sort the matrix diagonally
 */
public class SortMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = m - 1; i >= 0; i--) {
            int x = i, y = 0;
            while (x < m && y < n) {
                minHeap.offer(mat[x][y]);
                x++;
                y++;
            }

            x = i;
            y = 0;
            while (x < m && y < n) {
                mat[x][y] = minHeap.poll();
                x++;
                y++;
            }
        }

        for (int j = 1; j < n; j++) {
            int x = 0, y = j;
            while (x < m && y < n) {
                minHeap.offer(mat[x][y]);
                x++;
                y++;
            }

            x = 0;
            y = j;
            while (x < m && y < n) {
                mat[x][y] = minHeap.poll();
                x++;
                y++;
            }
        }

        return mat;
    }
}
