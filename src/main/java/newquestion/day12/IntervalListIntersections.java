package newquestion.day12;

/**
 * @author Heng Yu
 * @date 5/9/20 4:57 PM
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * leetcode 986: Interval list intersections
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection1(int[][] A, int[][] B) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        List<int[]> list = new ArrayList<>();

        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            int[] offer;
            if (A[i][0] <= B[j][0]) {
                offer = A[i];
                ++i;
            } else {
                offer = B[j];
                ++j;
            }
            if (!heap.isEmpty()) {
                int[] peek = heap.peek();
                if (offer[0] <= peek[1]) {
                    list.add(new int[]{offer[0], Math.min(peek[1], offer[1])});
                }
            }
            heap.offer(offer);
        }

        while (i < A.length) {
            int[] offer = A[i];
            if (!heap.isEmpty()) {
                int[] peek = heap.peek();
                if (offer[0] <= peek[1]) {
                    list.add(new int[]{offer[0], Math.min(peek[1], offer[1])});
                }
            }
            ++i;
        }

        while (j < B.length) {
            int[] offer = B[j];
            if (!heap.isEmpty()) {
                int[] peek = heap.peek();
                if (offer[0] <= peek[1]) {
                    list.add(new int[]{offer[0], Math.min(peek[1], offer[1])});
                }
            }
            ++j;
        }

        int[][] res = new int[list.size()][];

        for (int k = 0; k < res.length; ++k) {
            res[k] = list.get(k);
        }

        return res;
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();

        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][1] < B[j][1]) {
                if (A[i][1] >= B[j][0]) {
                    list.add(new int[]{Math.max(A[i][0], B[j][0]), A[i][1]});
                }
                ++i;
            } else if (A[i][1] > B[j][1]) {
                if (B[j][1] >= A[i][0]) {
                    list.add(new int[]{Math.max(A[i][0], B[j][0]), B[j][1]});
                }
                ++j;
            } else {
                list.add(new int[]{Math.max(A[i][0], B[j][0]), A[i][1]});
                ++i;
                ++j;
            }
        }

        int[][] res = new int[list.size()][];
        for (int k = 0; k < res.length; ++k) {
            res[k] = list.get(k);
        }

        return res;
    }
}
