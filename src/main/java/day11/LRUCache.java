package day11;

/**
 * @author Heng Yu
 * @date 3/7/20 5:18 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 146: LRU Cache
 */

public class LRUCache {
    private class Node {
        int key;
        int value;
        Node pred;
        Node succ;

        public Node() {
            this.key = -1;
            this.value = -1;
            this.pred = null;
            this.succ = null;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.pred = null;
            this.succ = null;
        }
    }

    private Node header;
    private Node trailer;
    private Map<Integer, Node> mapping;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.header = new Node();
        this.trailer = new Node();
        this.header.succ = this.trailer;
        this.trailer.pred = this.header;
        this.mapping = new HashMap<>();
        this.size = 0;
    }

    public int get(int key) {
        if (!mapping.containsKey(key)) return -1;
        Node node = mapping.get(key);
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        node.succ = trailer;
        node.pred = trailer.pred;
        node.pred.succ = node;
        node.succ.pred = node;
        return node.value;
    }

    public void put(int key, int value) {
        if (mapping.containsKey(key)) {
            Node node = mapping.get(key);
            node.value = value;
            node.pred.succ = node.succ;
            node.succ.pred = node.pred;
            node.succ = trailer;
            node.pred = trailer.pred;
            node.pred.succ = node;
            node.succ.pred = node;
            return;
        }
        Node node = new Node(key, value);
        node.succ = trailer;
        node.pred = trailer.pred;
        node.pred.succ = node.succ.pred = node;
        mapping.put(key, node);
        if (capacity == size) {
            Node head = header.succ;
            mapping.remove(head.key);
            header.succ = head.succ;
            header.succ.pred = header;
        } else {
            ++size;
        }
    }
}
