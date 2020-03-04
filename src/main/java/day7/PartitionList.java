package day7;

/**
 * @author Heng Yu
 * @date 3/3/20 10:08 PM
 */

import helper.ListNode;

/**
 * leetcode 86: Partition List
 */

public class PartitionList {
    public static void main(String[] args) {
        PartitionList solution = new PartitionList();
        int[] nums = new int[]{1, 4, 3, 2, 5, 2};
        ListNode head = ListNode.create(nums);
        ListNode result = solution.partition(head, 3);
        System.out.println(result);
    }

    public ListNode partition(ListNode head, int x) {
        //edge case
        if (head == null) return null;

        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode pred = header;
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        while (head != null) {
            if (head.val < x) {
                pred.next = head.next;
                head.next = null;
                cur.next = head;
                cur = cur.next;
                head = pred.next;
            } else {
                head = head.next;
                pred = pred.next;
            }
        }
        cur.next = header.next;
        return res.next;
    }
}
