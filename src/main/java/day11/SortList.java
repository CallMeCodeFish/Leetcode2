package day11;

/**
 * @author Heng Yu
 * @date 3/7/20 8:08 PM
 */

import helper.ListNode;

/**
 * leetcode 148: Sort List
 */

public class SortList {
    public static void main(String[] args) {
        SortList solution = new SortList();
        int[] nums = new int[]{4, 2, 1, 3};
        ListNode head = ListNode.create(nums);
        ListNode result = solution.sortList(head);
        System.out.println(result);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head) {
        //edge case
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = mergeSort(head);
        fast = mergeSort(fast);
        return merge(slow, fast);
    }

    private ListNode merge(ListNode n1, ListNode n2) {
        ListNode res = new ListNode(-1);
        ListNode pred = res;
        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                pred.next = n1;
                n1 = n1.next;
            } else {
                pred.next = n2;
                n2 = n2.next;
            }
            pred = pred.next;
        }
        while (n1 != null) {
            pred.next = n1;
            n1 = n1.next;
            pred = pred.next;
        }
        while (n2 != null) {
            pred.next = n2;
            n2 = n2.next;
            pred = pred.next;
        }
        return res.next;
    }
}
