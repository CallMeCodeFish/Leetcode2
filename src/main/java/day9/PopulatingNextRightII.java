package day9;

/**
 * @author Heng Yu
 * @date 3/5/20 9:54 PM
 */

import helper.Node;

/**
 * leetcode 117: Populating Next Right Pointers in Each Node
 */

public class PopulatingNextRightII {
    public static void main(String[] args) {
        PopulatingNextRightII solution = new PopulatingNextRightII();
        Node root = new Node(7);
        root.left = new Node(-10);
        root.right = new Node(2);
        root.left.left = new Node(-4);
        root.left.right = new Node(3);
        root.right.left = new Node(-8);
        root.left.right.right = new Node(-1);
        root.right.left.left = new Node(11);
        solution.connect(root);
    }

    public Node connect(Node root) {
        //edge case
        if (root == null) return null;

        helper(root);
        return root;
    }

    private void helper(Node node) {
        Node first = null;
        Node cur = null;
        while (node != null) {
            if (node.left != null && node.right != null) {
                if (first == null) {
                    first = node.left;
                }
                node.left.next = node.right;
                if (cur != null) {
                    cur.next = node.left;
                }
                cur = node.right;
            } else if (node.left != null) {
                if (first == null) {
                    first = node.left;
                }
                if (cur != null) {
                    cur.next = node.left;
                }
                cur = node.left;
            } else if (node.right != null) {
                if (first == null) {
                    first = node.right;
                }
                if (cur != null) {
                    cur.next = node.right;
                }
                cur = node.right;
            }
            node = node.next;
        }
        if (first != null) helper(first);
    }
}
