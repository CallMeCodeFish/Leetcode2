package day1;

/**
 * @author Heng Yu
 * @date 2/26/20 6:08 PM
 */

import helper.ListNode;

/**
 * leetcode 2: Add Two Numbers
 *
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        head.next = l1;
        int carryBit = 0;
        ListNode parent = head;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryBit;
            l1.val = sum % 10;
            carryBit = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            parent = parent.next;
        }

        while (l1 != null) {
            int sum = l1.val + carryBit;
            l1.val = sum % 10;
            carryBit = sum / 10;
            l1 = l1.next;
            parent = parent.next;
        }

        while (l2 != null) {
            int sum = l2.val + carryBit;
            parent.next = new ListNode(sum % 10);
            carryBit = sum / 10;
            l2 = l2.next;
            parent = parent.next;
        }

        if (carryBit != 0) {
            parent.next = new ListNode(carryBit);
        }

        return head.next;
    }
}
