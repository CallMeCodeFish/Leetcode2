package newquestion.day61;

import java.util.PriorityQueue;

/**
 * @author Heng Yu
 * @date 7/25/20 4:38 PM
 */

/**
 * leetcode 451: Sort characters by frequency
 */
public class SortCharactersByFreq {
    private static class Node {
        char c;
        int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        int[] freq = new int[128];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            ++freq[c];
        }

        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new Node((char) i, freq[i]));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Node node = maxHeap.poll();
            char c = node.c;
            int n = node.count;
            while (n > 0) {
                sb.append(c);
                n--;
            }
        }

        return sb.toString();
    }
}
