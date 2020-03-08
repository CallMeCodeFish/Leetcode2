package day11;

/**
 * @author Heng Yu
 * @date 3/7/20 3:36 PM
 */


import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 138: Copy List with Random Pointer
 */

public class CopyListWithRandom {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //edge case
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node header = new Node(-1);
        header.next = head;
        Node res = new Node(-1);
        Node cur = res;
        while (head != null) {
            cur.next = new Node(head.val);
            map.put(head, cur.next);
            head = head.next;
            cur = cur.next;
        }
        cur = res.next;
        head = header.next;
        while (head != null) {
            cur.random = map.get(head.random);
            head = head.next;
            cur = cur.next;
        }
        return res.next;
    }
}
