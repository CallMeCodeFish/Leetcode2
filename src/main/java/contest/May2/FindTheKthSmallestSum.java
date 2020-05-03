package contest.May2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 5/2/20 11:19 PM
 */


public class FindTheKthSmallestSum {
    private static class Node {
        int sum;
        int[] indices;

        public Node(int sum, int[] indices) {
            this.sum = sum;
            this.indices = indices;
        }
    }

    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int s = 0;
        for (int[] row : mat) {
            s += row[0];
        }

        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        Node node = new Node(s, new int[m]);
        heap.offer(node);
        Set<Integer> visited = new HashSet<>();

        int res = 0;
        while (!heap.isEmpty()) {
            if (k == 0) break;
            node = heap.poll();
            res = node.sum;
            for (int i = 0; i < m; ++i) {
                if (node.indices[i] + 1 < n) {
                    int[] indices = node.indices.clone();
                    ++indices[i];
                    int hashCode = Arrays.hashCode(indices);
                    if (!visited.contains(hashCode)) {
                        visited.add(hashCode);
                        int sum = node.sum - mat[i][node.indices[i]] + mat[i][indices[i]];
                        Node next = new Node(sum, indices);
                        heap.offer(next);
                    }
                }
            }
            --k;
        }
        return res;
    }
}
