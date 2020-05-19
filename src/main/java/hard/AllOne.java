package hard;

/**
 * @author Heng Yu
 * @date 5/18/20 5:53 PM
 */

import java.util.*;

/**
 * leetcode 432: All O(1) data structure
 */
public class AllOne {
    public static void main(String[] args) {
        AllOne solution = new AllOne();
        String result = null;

        solution.inc("hello");
        solution.inc("world");
        solution.inc("hello");
        solution.dec("world");
        solution.inc("hello");
        solution.inc("leet");

        result = solution.getMaxKey();
        System.out.println(result);

        solution.dec("hello");
        solution.dec("hello");
        solution.dec("hello");

        result = solution.getMaxKey();
        System.out.println(result);
    }

    private static class Node {
        Node prev;
        Node next;
        Set<String> set;

        public Node() {
            this.prev = null;
            this.next = null;
            this.set = new HashSet<>();
        }
    }

    /** minimum side */
    private Node header;

    /** maximum side */
    private Node trailer;

    private Map<Integer, Node> nodes;

    private Map<String, Integer> freq;

    /** Initialize your data structure here. */
    public AllOne() {
        this.header = new Node();
        this.trailer = new Node();
        this.header.next = this.trailer;
        this.trailer.prev = this.header;
        this.nodes = new HashMap<>();
        this.freq = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (!freq.containsKey(key)) {
            freq.put(key, 1);
            if (!nodes.containsKey(1)) {
                Node node = new Node();
                node.set.add(key);
                Node next = header.next;
                header.next = node;
                node.prev = header;
                next.prev = node;
                node.next = next;
                nodes.put(1, node);
            } else {
                nodes.get(1).set.add(key);
            }
        } else {
            int oldCount = freq.get(key);
            int newCount = oldCount + 1;
            if (!nodes.containsKey(newCount)) {
                Node node = new Node();
                node.set.add(key);
                Node prev = nodes.get(oldCount);
                Node next = prev.next;
                prev.next = node;
                node.prev = prev;
                next.prev = node;
                node.next = next;
                nodes.put(newCount, node);
            } else {
                nodes.get(newCount).set.add(key);
            }
            Node node = nodes.get(oldCount);
            node.set.remove(key);
            if (node.set.isEmpty()) {
                Node prev = node.prev;
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
                nodes.remove(oldCount);
            }
            freq.replace(key, newCount);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (freq.containsKey(key)) {
            int oldCount = freq.get(key);
            int newCount = oldCount - 1;
            if (newCount == 0) {
                Node node = nodes.get(oldCount);
                node.set.remove(key);
                if (node.set.isEmpty()) {
                    Node next = node.next;
                    header.next = next;
                    next.prev = header;
                    nodes.remove(oldCount);
                }
                freq.remove(key);
            } else {
                if (!nodes.containsKey(newCount)) {
                    Node node = new Node();
                    node.set.add(key);
                    Node next = nodes.get(oldCount);
                    Node prev = next.prev;
                    prev.next = node;
                    node.prev = prev;
                    next.prev = node;
                    node.next = next;
                    nodes.put(newCount, node);
                } else {
                    nodes.get(newCount).set.add(key);
                }
                Node node = nodes.get(oldCount);
                node.set.remove(key);
                if (node.set.isEmpty()) {
                    Node prev = node.prev;
                    Node next = node.next;
                    prev.next = next;
                    next.prev = prev;
                    nodes.remove(oldCount);
                }
                freq.replace(key, newCount);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (trailer.prev == header) return "";

        String res = null;
        Node last = trailer.prev;
        for (String s : last.set) {
            res = s;
            break;
        }
        return res;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (header.next == trailer) return "";

        String res = null;
        Node first = header.next;
        for (String s : first.set) {
            res = s;
            break;
        }
        return res;
    }
}
