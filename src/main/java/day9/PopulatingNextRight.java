package day9;

import helper.Node;

/**
 * @author Heng Yu
 * @date 3/5/20 9:10 PM
 */

/**
 * leetcode 116: Populating Next Right Pointers in Each Node
 */

public class PopulatingNextRight {
    public static void main(String[] args) {
        PopulatingNextRight solution = new PopulatingNextRight();

    }

    public Node connect(Node root) {
        //edge case
        if (root == null) return null;

        helper(root);
        return root;
    }

    private void helper(Node node) {
        //edge case
        if (node.left == null) return;

        node.left.next = node.right;
        if (node.next != null) {
            node.right.next = node.next.left;
        }
        helper(node.left);
        helper(node.right);
    }
}
