package newquestion.day36;

import helper.ListNode;

/**
 * @author Heng Yu
 * @date 6/15/20 6:39 PM
 */

/**
 * leetcode 876: Middle of the linked list
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode node = head;

        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }

        int n = len / 2;

        while (n > 0) {
            head = head.next;
            n--;
        }

        return head;
    }
}
