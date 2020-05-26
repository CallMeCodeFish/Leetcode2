package newquestion.day21;

/**
 * @author Heng Yu
 * @date 5/25/20 3:56 PM
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * leetcode 945:  Minimum Increment to Make Array Unique
 */
public class MinimumIncrement {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0;

        for (int i = 1; i < A.length; ++i) {
            if (A[i] <= A[i - 1]) {
                res += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }

        return res;
    }


    private static class Node {
        int value;
        int count;
        Node next;

        public Node(int value, int count) {
            this.value = value;
            this.count = count;
            this.next = null;
        }

        public Node() {
            this.value = 0;
            this.count = 0;
            this.next = null;
        }
    }

    public int minIncrementForUnique1(int[] A) {
        //edge case
        if (A.length < 2) return 0;

        TreeMap<Integer, Integer> counts = new TreeMap<>();

        for (int num : A) {
            if (!counts.containsKey(num)) counts.put(num, 0);
            counts.replace(num, counts.get(num) + 1);
        }

        Map<Integer, Node> valueToNode = new HashMap<>();

        Node dummy = new Node();
        Node cur = dummy;

        for (int num : counts.keySet()) {
            cur.next = new Node(num, counts.get(num));
            cur = cur.next;
            valueToNode.put(num, cur);
        }

        int res = 0;
        cur = dummy.next;
        while (cur != null) {
            int nextCount = cur.count - 1;
            if (nextCount != 0) {
                res += nextCount;
                int nextNum = cur.value + 1;
                if (valueToNode.containsKey(nextNum)) {
                    valueToNode.get(nextNum).count += nextCount;
                } else if (nextCount > 1) {
                    Node node = new Node(nextNum, nextCount);
                    node.next = cur.next;
                    cur.next = node;
                    valueToNode.put(nextNum, node);
                }
            }
            cur = cur.next;
        }

        return res;
    }
}
