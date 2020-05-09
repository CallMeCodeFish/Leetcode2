package newquestion.day11;

/**
 * @author Heng Yu
 * @date 5/8/20 5:15 PM
 */

/**
 * leetcode 706: Design HashMap
 */
public class MyHashMap {
    private static class ListNode {
        int key;
        int value;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int CAPACITY = 10000;
    private ListNode[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.map = new ListNode[CAPACITY];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        ListNode predecessor = findPredecessor(key);
        if (predecessor.next == null) {
            predecessor.next = new ListNode(key, value);
        } else {
            predecessor.next.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        ListNode predecessor = findPredecessor(key);
        return (predecessor.next == null)? -1 : predecessor.next.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        ListNode predecessor = findPredecessor(key);
        if (predecessor.next != null) {
            ListNode cur = predecessor.next;
            predecessor.next = cur.next;
        }
    }

    private ListNode findPredecessor(int key) {
        int index = Math.abs(Integer.hashCode(key) % CAPACITY);
        if (map[index] == null) {
            map[index] = new ListNode(-1, -1);
            return map[index];
        }

        ListNode pred = map[index];
        while (pred.next != null) {
            if (pred.next.key == key) break;
            pred = pred.next;
        }

        return pred;
    }
}
