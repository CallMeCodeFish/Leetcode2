package day18;

/**
 * @author Heng Yu
 * @date 3/15/20 4:46 PM
 */

import helper.ListNode;

/**
 * leetcode 234: Palindrome Linked List
 */

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        //edge case
        if (head == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        if (fast == null) return true;
        slow.next = null;
        ListNode header = new ListNode(-1);
        header.next = fast;
        while (fast.next != null) {
            ListNode cur = fast.next;
            fast.next = cur.next;
            cur.next = header.next;
            header.next = cur;
        }
        slow = head;
        fast = header.next;
        while (fast != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
