package day13;

/**
 * @author Heng Yu
 * @date 3/10/20 6:10 PM
 */

import helper.ListNode;

/**
 * leetcode Intersection of Two Linked Lists
 */

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //edge case
        if (headA == null || headB == null) return null;

        ListNode node1 = headA;
        ListNode node2 = headB;
        boolean flag = true;
        while (node1 != null) {
            if (node1 == node2) return node1;
            if (node1.next == null && flag) {
                node1 = headB;
                flag = false;
            } else {
                node1 = node1.next;
            }
            if (node2.next == null) {
                node2 = headA;
            } else {
                node2 = node2.next;
            }
        }
        return null;
    }
}
