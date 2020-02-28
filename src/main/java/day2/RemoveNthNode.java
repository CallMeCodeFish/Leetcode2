package day2;

/**
 * @author Heng Yu
 * @date 2/27/20 8:47 PM
 */

import helper.ListNode;

/**
 * leetcode 19: Remove Nth Node From End of List
 */

public class RemoveNthNode {
    public static void main(String[] args) {
        RemoveNthNode solution = new RemoveNthNode();
        int[] nums = new int[]{1};
        ListNode head = ListNode.create(nums);
        ListNode result = solution.removeNthFromEnd(head, 1);
        System.out.println(result);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //edge case
        if (head == null)   return null;

        ListNode header = new ListNode(-1);
        header.next = head;
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        n = length - n;
        ListNode pred = header;
        head = header.next;
        for (int i = 0; i < n; ++i) {
            pred = pred.next;
            head = head.next;
        }
        pred.next = head.next;
        head.next = null;
        head = header.next;
        return head;
    }
}
