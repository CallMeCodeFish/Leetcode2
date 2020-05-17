package hard;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/16/20 5:54 PM
 */

/**
 * leetcode 218: The skyline problem
 * reference: https://www.bilibili.com/video/BV11J411c7KV?from=search&seid=16565360332674651145
 */
public class Skyline {
    public static void main(String[] args) {
        Skyline solution = new Skyline();
        int[][] buildings = {{0, 2, 3}, {2, 5, 3}};
        List<List<Integer>> result = solution.getSkyline(buildings);
        System.out.println(result);
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        for (int[] b : buildings) {
            if (!map.containsKey(b[0])) map.put(b[0], new ArrayList<>());
            if (!map.containsKey(b[1])) map.put(b[1], new ArrayList<>());
            map.get(b[0]).add(b);
            map.get(b[1]).add(b);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        List<List<Integer>> res = new ArrayList<>();

        for (int x : map.keySet()) {
            List<int[]> bs = map.get(x);
            for (int[] b : bs) {
                if (b[0] == x) {
                    maxHeap.offer(b);
                } else {
                    maxHeap.remove(b);
                }
            }

            if (maxHeap.isEmpty()) {
                res.add(Arrays.asList(x, 0));
            } else {
                int maxHeight = maxHeap.peek()[2];
                if (res.isEmpty() || res.get(res.size() - 1).get(1) != maxHeight) {
                    res.add(Arrays.asList(x, maxHeight));
                }
            }
        }

        return res;
    }

    public List<List<Integer>> getSkyline1(int[][] buildings) {
        int len = buildings.length;
        int[][] points = new int[2 * len][];
        int k = 0;
        for (int[] building : buildings) {
            points[k++] = new int[]{building[0], -building[2]};
            points[k++] = new int[]{building[1], building[2]};
        }

        Arrays.sort(points, (a, b) -> (a[0] != b[0]) ? a[0] - b[0] : a[1] - b[1]);

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        heap.offer(0);

        List<List<Integer>> res = new ArrayList<>();

        int prevHeight = 0;
        for (int[] point : points) {
            if (point[1] < 0) {
                heap.offer(-point[1]);
            } else {
                heap.remove(point[1]);
            }
            if (prevHeight != heap.peek()) {
                prevHeight = heap.peek();
                res.add(Arrays.asList(point[0], prevHeight));
            }
        }

        return res;
    }
}
