package day8;

import helper.ListNode;

/**
 * @author Heng Yu
 * @date 3/4/20 5:37 PM
 */

/**
 * leetcode 92: Reverse Linked List II
 */

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode pred = header;
        int i = 0;
        while (i < m - 1) {
            pred = pred.next;
            head = head.next;
            ++i;
        }
        i = 0;
        while (i < n - m) {
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pred.next;
            pred.next = cur;
            ++i;
        }
        return header.next;
    }
}