package day11;

/**
 * @author Heng Yu
 * @date 3/7/20 4:42 PM
 */

import helper.ListNode;

/**
 * leetcode 142: Linked List Cycle II
 */

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        //edge case
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
