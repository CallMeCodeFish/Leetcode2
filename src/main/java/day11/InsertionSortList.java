package day11;

/**
 * @author Heng Yu
 * @date 3/7/20 6:38 PM
 */

import helper.ListNode;

/**
 * leetcode 147: Insertion Sort List
 */

public class InsertionSortList {
    public static void main(String[] args) {
        InsertionSortList solution = new InsertionSortList();
        int[] nums = new int[]{4, 2, 1, 3};
        ListNode head = ListNode.create(nums);
        ListNode result = solution.insertionSortList(head);
        System.out.println(result);
    }

    public ListNode insertionSortList(ListNode head) {
        //edge case
        if (head == null) return null;

        ListNode header = new ListNode(-1);
        while (head != null) {
            ListNode target = head;
            head = head.next;
            if (header.next == null) {
                target.next = null;
                header.next = target;
            } else {
                ListNode pred = header;
                while (pred.next != null) {
                    ListNode cur = pred.next;
                    if (target.val < cur.val) {
                        break;
                    }
                    pred = pred.next;
                }
                target.next = pred.next;
                pred.next = target;
            }
        }
        return header.next;
    }
}
