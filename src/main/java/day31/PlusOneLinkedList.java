package day31;

import helper.ListNode;

/**
 * @author Heng Yu
 * @date 4/7/20 9:18 PM
 */

/**
 * leetcode 369: Plus One Linked List
 */

public class PlusOneLinkedList {
    public static void main(String[] args) {
        PlusOneLinkedList solution = new PlusOneLinkedList();
        ListNode head = ListNode.create(new int[]{1, 2, 3});
        ListNode result = solution.plusOne(head);
        System.out.println(result);
    }

    public ListNode plusOne(ListNode head) {
        if (head == null) return null;

        head = reverseList(head);
        increment(head);
        head = reverseList(head);
        return head;
    }

    private void increment(ListNode head) {
        int carry = 1;
        ListNode pred = new ListNode(-1);
        pred.next = head;
        while (pred.next != null) {
            if (carry == 0) break;
            ListNode cur = pred.next;
            int sum = cur.val + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            pred = pred.next;
        }
        if (carry != 0) {
            pred.next = new ListNode(carry);
        }
    }

    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head.next != null) {
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }
}
