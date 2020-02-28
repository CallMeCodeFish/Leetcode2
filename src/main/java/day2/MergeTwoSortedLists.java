package day2;

/**
 * @author Heng Yu
 * @date 2/27/20 9:46 PM
 */

import helper.ListNode;

/**
 * leetcode 21: Merge Two Sorted Lists
 */

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        int[] nums1 = new int[]{2};
        ListNode l1 = ListNode.create(nums1);
        int[] nums2 = new int[]{1};
        ListNode l2 = ListNode.create(nums2);
        ListNode result = solution.mergeTwoLists(l1, l2);
        System.out.println(result);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(-1);
        ListNode pred = header;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pred.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                pred.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            pred = pred.next;
        }

        while (l1 != null) {
            pred.next = new ListNode(l1.val);
            pred = pred.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            pred.next = new ListNode(l2.val);
            pred = pred.next;
            l2 = l2.next;
        }

        return header.next;
    }
}
