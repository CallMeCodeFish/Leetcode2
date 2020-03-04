package day7;

/**
 * @author Heng Yu
 * @date 3/3/20 9:57 PM
 */

import helper.ListNode;

/**
 * leetcode 83: Remove Duplicates from Sorted List
 */

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        //edge case
        if (head == null) return null;

        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode pred = header;
        while (head != null) {
            ListNode next = head.next;
            if (next != null && next.val == head.val) {
                while (next != null && next.val == head.val) {
                    next = next.next;
                }
                head.next = next;
            }
            pred = pred.next;
            head = head.next;
        }
        return header.next;
    }
}
