package hard;

/**
 * @author Heng Yu
 * @date 5/23/20 8:10 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 460: LFU cache
 */
public class LFUCache {
    public static void main(String[] args) {
        LFUCache solution = new LFUCache(2);

        solution.put(1,1);
        solution.put(2,2);
        System.out.println(solution.get(1));
        solution.put(3,3);
        System.out.println(solution.get(2));
        System.out.println(solution.get(3));
        solution.put(4,4);
        System.out.println(solution.get(1));
        System.out.println(solution.get(3));
        System.out.println(solution.get(4));

    }

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node() {
            this.value = 0;
            this.prev = null;
            this.next = null;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;

    // Least frequent side
    private Node header;

    // Most frequent side
    private Node trailer;

    private Map<Integer, Node> nodes;

    private Map<Node, Integer> nodeToFreq;

    private Map<Integer, Node[]> intervals;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.nodes = new HashMap<>();
        this.nodeToFreq = new HashMap<>();
        this.intervals = new HashMap<>();
        this.header = new Node();
        this.trailer = new Node();
        this.header.next = this.trailer;
        this.trailer.prev = this.header;
    }

    public int get(int key) {
        if (!nodes.containsKey(key)) return -1;

        Node node = nodes.get(key);

        //frequency of this node increments, so update
        incrementFreq(node);

        return node.value;
    }

    private void incrementFreq(Node node) {
        int oldFreq = nodeToFreq.get(node);
        Node[] oldInterval = intervals.get(oldFreq);

        // isolate the node from the old frequency group
        node.prev.next = node.next;
        node.next.prev = node.prev;
        boolean canRemove = false;
        if (oldInterval[0] == oldInterval[1]) {
            // group contains only the node, the group should be removed from #{interval}
            intervals.remove(oldFreq);
            canRemove = true;
        } else {
            if (oldInterval[0] == node) {
                // update the lower bound of this group
                oldInterval[0] = node.next;
            } else if (oldInterval[1] == node) {
                // update the upper bound of this group
                oldInterval[1] = node.prev;
            }
        }

        int newFreq = oldFreq + 1;
        //insert node into new group
        if (!intervals.containsKey(newFreq)) {
            intervals.put(newFreq, new Node[]{node, node});
            Node last = (canRemove)? node.prev : oldInterval[1];
            node.next = last.next;
            last.next = node;
            node.prev = last;
            node.next.prev = node;
        } else {
            Node[] newInterval = intervals.get(newFreq);
            Node last = newInterval[1];
            newInterval[1] = node;
            node.next = last.next;
            last.next = node;
            node.next.prev = node;
            node.prev = last;
        }

        nodeToFreq.replace(node, nodeToFreq.get(node) + 1);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (!nodes.containsKey(key)) {
            if (nodes.size() == capacity) {
                //remove the leftmost node
                removeFirst();
            }
            insertNode(key, value);
        } else {
            Node node = nodes.get(key);
            node.value = value;
            incrementFreq(node);
        }
    }

    private void removeFirst() {
        Node first = header.next;
        header.next = first.next;
        header.next.prev = header;
        nodes.remove(first.key);

        int freq = nodeToFreq.get(first);
        nodeToFreq.remove(first);

        Node[] interval = intervals.get(freq);
        if (interval[0] == interval[1]) {
            intervals.remove(freq);
        } else {
            interval[0] = first.next;
        }
    }

    private void insertNode(int key, int value) {
        Node node = new Node(key, value);
        nodes.put(key, node);
        nodeToFreq.put(node, 1);

        if (!intervals.containsKey(1)) {
            // create group with frequency 1
            intervals.put(1, new Node[]{node, node});

            node.next = header.next;
            header.next = node;
            node.prev = header;
            node.next.prev = node;
        } else {
            Node[] interval = intervals.get(1);
            Node last = interval[1];
            interval[1] = node;

            node.next = last.next;
            last.next = node;
            node.prev = last;
            node.next.prev = node;
        }
    }
}
