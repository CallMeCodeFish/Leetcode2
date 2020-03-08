package day11;

/**
 * @author Heng Yu
 * @date 3/7/20 4:49 PM
 */

import helper.ListNode;

/**
 * leetcode 143: Reorder List
 */

public class ReorderList {
    public void reorderList(ListNode head) {
        //edge case
        if (head == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        if (fast == null) return;
        slow.next = null;
        slow = new ListNode(-1);
        slow.next = fast;
        while (fast.next != null) {
            ListNode cur = fast.next;
            fast.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
        }
        fast = slow.next;
        ListNode header = new ListNode(-1);
        while (fast != null) {
            header.next = head;
            head = head.next;
            header = header.next;
            header.next = fast;
            fast = fast.next;
            header = header.next;
        }
        if (head != null) header.next = head;
    }
}
