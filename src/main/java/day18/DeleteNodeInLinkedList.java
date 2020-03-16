package day18;

import helper.ListNode;

/**
 * @author Heng Yu
 * @date 3/15/20 5:57 PM
 */

/**
 * leetcode 237: Delete Node in a Linked List
 */

public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
