package day11;

import helper.ListNode;

/**
 * @author Heng Yu
 * @date 3/7/20 4:36 PM
 */


public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        //edge case
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
