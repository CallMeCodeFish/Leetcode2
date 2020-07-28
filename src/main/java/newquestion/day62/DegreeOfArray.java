package newquestion.day62;

import java.util.*;

/**
 * @author Heng Yu
 * @date 7/27/20 4:59 PM
 */

/**
 * leetcode 697: Degree of an array
 */
public class DegreeOfArray {
    private static class Node {
        int start;
        int end;
        int freq;

        public Node(int index) {
            start = end = index;
            freq = 1;
        }
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> a.freq == b.freq ? a.end - a.start - (b.end - b.start) : b.freq - a.freq);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                Node node = new Node(i);
                map.put(num, node);
                heap.offer(node);
            } else {
                Node node = map.get(num);
                heap.remove(node);
                node.end = i;
                node.freq++;
                heap.offer(node);
            }
        }

        Node node = heap.poll();
        return node.end - node.start + 1;
    }
}
