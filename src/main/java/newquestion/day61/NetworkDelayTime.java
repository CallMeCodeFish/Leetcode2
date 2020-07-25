package newquestion.day61;

import java.util.*;

/**
 * @author Heng Yu
 * @date 7/25/20 4:24 PM
 */

/**
 * leetcode 743: Network delay time
 * solution: dijkstra
 */
public class NetworkDelayTime {
    private static class Node {
        int id;
        int delay;

        public Node(int id, int delay) {
            this.id = id;
            this.delay = delay;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        //cost matrix
        Map<Integer, Integer>[] costs = new Map[N + 1];
        Node[] nodes = new Node[N + 1];
        for (int i = 0; i <= N; i++) {
            costs[i] = new HashMap<>();
            nodes[i] = new Node(i, Integer.MAX_VALUE);
        }

        nodes[K].delay = 0;

        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int t = time[2];
            costs[from].put(to, t);
        }

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.delay - b.delay);
        Map<Integer, Integer> start = costs[K];
        for (int i = 1; i <= N; i++) {
            if (i != K) {
                if (start.containsKey(i)) {
                    nodes[i].delay = start.get(i);
                }
                minHeap.offer(nodes[i]);
            }
        }

        while (!minHeap.isEmpty()) {
            Node poll = minHeap.poll();
            if (poll.delay == Integer.MAX_VALUE) return -1;
            Map<Integer, Integer> cost = costs[poll.id];
            for (int nextId : cost.keySet()) {
                Node node = nodes[nextId];
                int nd = poll.delay + cost.get(nextId);
                if (nd < node.delay) {
                    minHeap.remove(node);
                    node.delay = nd;
                    minHeap.offer(node);
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= N; i++) {
            res = Math.max(res, nodes[i].delay);
        }

        return res;
    }
}
