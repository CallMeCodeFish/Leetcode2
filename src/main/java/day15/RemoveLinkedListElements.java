package day15;

/**
 * @author Heng Yu
 * @date 3/12/20 11:05 PM
 */

import helper.ListNode;

/**
 * leetcode 203: Remove Linked List Elements
 */

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        //edge case
        if (head == null) return null;

        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode pred = header;
        while (pred.next != null) {
            ListNode cur = pred.next;
            if (cur.val == val) {
                pred.next = cur.next;
                cur.next = null;
            } else {
                pred = pred.next;
            }
        }
        return header.next;
    }
}
