package newquestion.day6;


/**
 * @author Heng Yu
 * @date 5/1/20 8:36 PM
 */

/**
 * leetcode 430: Flatten a multi-level doubly linked list
 */
public class FlattenLinkedList {
    private static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }



    public static void main(String[] args) {
        FlattenLinkedList solution = new FlattenLinkedList();
        Node head = new Node();
        head.val = 1;
        head.next = new Node();
        head.next.val = 2;
        head.child = new Node();
        head.child.val = 3;
        solution.flatten(head);
    }

    public Node flatten(Node head) {
        if (head == null) return null;

        helper(head);
        return head;

    }

    private Node helper(Node head) {
        while (head.next != null) {
            if (head.child != null) {
                Node last = helper(head.child);
                last.next = head.next;
                last.next.prev = last;
                head.next = head.child;
                head.child = null;
                head.next.prev = head;
                head = last.next;
            } else {
                head = head.next;
            }
        }

        if (head.child != null) {
            Node last = helper(head.child);
            head.next = head.child;
            head.next.prev = head;
            head.child = null;
            return last;
        }

        return head;
    }
}
