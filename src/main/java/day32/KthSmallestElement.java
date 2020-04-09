package day32;

/**
 * @author Heng Yu
 * @date 4/8/20 7:03 PM
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 378: Kth Smallest Element in a Sorted Matrix
 */

public class KthSmallestElement {
    private static class Node {
        int row;
        int col;
        int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; ++i) {
            heap.offer(new Node(i, 0, matrix[i][0]));
        }
        int res = 0;
        int count = 0;
        while (count < k) {
            Node node = heap.poll();
            res = node.val;
            if (node.col < n - 1) {
                ++node.col;
                node.val = matrix[node.row][node.col];
                heap.offer(node);
            }
            ++count;
        }
        return res;
    }
}
