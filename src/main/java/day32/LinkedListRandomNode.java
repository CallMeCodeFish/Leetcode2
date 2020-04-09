package day32;

import helper.ListNode;

/**
 * @author Heng Yu
 * @date 4/8/20 8:36 PM
 */

/**
 * leetcode 382: Linked List Random Node
 */

public class LinkedListRandomNode {
    private ListNode head;
    private int len;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }
        this.len = len;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int index = (int) (Math.random() * len);
        ListNode cur = head;
        while (index-- > 0) {
            cur = cur.next;
        }
        return cur.val;
    }
}
