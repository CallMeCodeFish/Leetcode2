package newquestion.day15;


import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author Heng Yu
 * @date 5/13/20 2:58 PM
 */

/**
 * leetcode 716: Max stack
 */
public class MaxStack {
    private static class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode trailer;
    private TreeMap<Integer, Deque<ListNode>> map;

    /** initialize your data structure here. */
    public MaxStack() {
        this.trailer = new ListNode(-1);
        this.map = new TreeMap<>((a, b) -> b - a);
    }

    public void push(int x) {
        ListNode node = new ListNode(x);
        ListNode next = trailer.next;
        trailer.next = node;
        node.next = next;
        node.prev = trailer;
        if (next != null) next.prev = node;

        Deque<ListNode> nodes = map.getOrDefault(x, new LinkedList<>());
        nodes.push(node);
        map.put(x, nodes);
    }

    public int pop() {
        ListNode pop = trailer.next;
        ListNode next = pop.next;
        trailer.next = next;
        if (next != null) next.prev = trailer;
        map.get(pop.val).pop();
        if (map.get(pop.val).isEmpty()) map.remove(pop.val);
        return pop.val;
    }

    public int top() {
        return trailer.next.val;
    }

    public int peekMax() {
        return map.firstKey();
    }

    public int popMax() {
        int max = map.firstKey();
        ListNode pop = map.get(max).pop();
        if (map.get(max).isEmpty()) map.remove(max);
        pop.prev.next = pop.next;
        if (pop.next != null) pop.next.prev = pop.prev;
        return pop.val;
    }
}
