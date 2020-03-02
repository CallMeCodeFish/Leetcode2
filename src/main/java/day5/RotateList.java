package day5;

/**
 * @author Heng Yu
 * @date 3/1/20 10:26 PM
 */

import helper.ListNode;

/**
 * leetcode 61: Rotate List
 */

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        //edge case
        if (head == null) return null;
        if (k == 0) return head;

        ListNode header = new ListNode(-1);
        header.next = head;
        int len = 0;
        ListNode last = header;
        while (last.next != null) {
            ++len;
            last = last.next;
        }
        k %= len;
        if (k == 0) return head;
        int shift = len - k;
        ListNode pred = header;
        while (0 < shift) {
            pred = pred.next;
            --shift;
        }
        ListNode cur = pred.next;
        pred.next = null;
        last.next = header.next;
        header.next = cur;
        return header.next;
    }
}
