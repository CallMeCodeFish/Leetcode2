package newquestion.day38;


/**
 * @author Heng Yu
 * @date 6/19/20 4:43 PM
 */

/**
 * leetcode 708: Insert into a sorted circular linked list
 */
public class InsertIntoSortedCircularLinkedList {
    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node node = head;
        boolean canFind = false;
        while (true) {
            if (node.val > node.next.val) {
                canFind = true;
                break;
            }
            node = node.next;
            if (node == head) break;
        }

        Node insert = new Node(insertVal);

        if (!canFind || node.val <= insertVal || insertVal < node.next.val) {
            insert.next = node.next;
            node.next = insert;
        } else {
            Node first = node.next;
            Node last = node;
            node = first;
            while (node != last) {
                if (node.val <= insertVal && insertVal < node.next.val) break;
                node = node.next;
            }
            insert.next = node.next;
            node.next = insert;
        }

        return head;
    }
}
