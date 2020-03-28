package day27;

import helper.ListNode;

/**
 * @author Heng Yu
 * @date 3/27/20 12:22 PM
 */


public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        //edge case
        if (head == null) return null;

        ListNode oddHeader = new ListNode(-1);
        ListNode evenHeader = new ListNode(-1);
        ListNode oddPred = oddHeader;
        ListNode evenPred = evenHeader;
        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                oddPred.next = head;
                head = head.next;
                oddPred = oddPred.next;
                oddPred.next = null;
                isOdd = false;
            } else {
                evenPred.next = head;
                head = head.next;
                evenPred = evenPred.next;
                evenPred.next = null;
                isOdd = true;
            }
        }
        oddPred.next = evenHeader.next;
        return oddHeader.next;
    }
}
