package day15;

/**
 * @author Heng Yu
 * @date 3/12/20 11:58 PM
 */

import helper.ListNode;

/**
 * leetcode 206: Reverse Linked List
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //edge case
        if (head == null) return null;

        ListNode header = new ListNode(-1);
        header.next = head;
        while (head.next != null) {
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = header.next;
            header.next = cur;
        }
        return header.next;
    }
}
