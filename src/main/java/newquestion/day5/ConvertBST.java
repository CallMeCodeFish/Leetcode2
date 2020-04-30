package newquestion.day5;

import helper.Node;

/**
 * @author Heng Yu
 * @date 4/29/20 4:24 PM
 */

/**
 * leetcode 426: Convert Binary Search Tree to Sorted Doubly Linked List
 */
public class ConvertBST {
    public Node treeToDoublyList(Node root) {
        //edge case
        if (root == null) return null;

        Node first = helper(root, null);
        Node last = first;
        while (last.right != null) {
            last = last.right;
        }
        first.left = last;
        last.right = first;

        return first;
    }

    private Node helper(Node node, Node succ) {
        Node res = (node.left == null)? node : helper(node.left, node);

        if (node.right != null) {
            Node right = helper(node.right, succ);
            right.left = node;
            node.right = right;
        } else {
            node.right = succ;
            if (succ != null) succ.left = node;
        }

        return res;
    }
}
