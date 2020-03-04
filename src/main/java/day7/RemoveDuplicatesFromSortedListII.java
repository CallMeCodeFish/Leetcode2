package day7;

import helper.ListNode;

/**
 * @author Heng Yu
 * @date 3/3/20 9:28 PM
 */


public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();
        int[] nums = new int[]{1,1,1,2,3};
        ListNode head = ListNode.create(nums);
        ListNode result = solution.deleteDuplicates(head);
        System.out.println(result);
    }

    public ListNode deleteDuplicates(ListNode head) {
        //edge case
        if (head == null) return null;

        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode pred = header;
        ListNode cur = pred.next;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null || next.val != cur.val) {
                cur = cur.next;
                pred = pred.next;
            } else {
                while (next != null && next.val == cur.val) {
                    next = next.next;
                }
                cur = next;
                pred.next = cur;
            }
        }
        return header.next;
    }
}
