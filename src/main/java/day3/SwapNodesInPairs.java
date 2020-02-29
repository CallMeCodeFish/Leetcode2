package day3;

/**
 * @author Heng Yu
 * @date 2/28/20 5:10 PM
 */

import helper.ListNode;

/**
 * leetcode 24: Swap Nodes in Pairs
 */

public class SwapNodesInPairs {
    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNode.create(nums);
        ListNode result = solution.swapPairs(head);
        System.out.println(result);
    }

    public ListNode swapPairs(ListNode head) {
        //edge case
        if (head == null)   return null;

        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode pred = header;
        while (head != null && head.next != null) {
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = head;
            pred.next = cur;
            pred = head;
            head = head.next;
        }
        head = header.next;
        return head;
    }
}
