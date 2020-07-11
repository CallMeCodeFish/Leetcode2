package newquestion.day52;

/**
 * @author Heng Yu
 * @date 7/11/20 4:38 PM
 */

/**
 * leetcode 510: Inorder successor in BST II
 */
public class InorderSuccessor {
    private static class Node {
        int val;
        Node left;
        Node right;
        Node parent;
    }

    public Node inorderSuccessor(Node node) {
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            while (node.parent != null && node == node.parent.right) node = node.parent;

            if (node.parent == null) {
                return null;
            } else {
                return node.parent;
            }
        }
    }

    private Node getLeftMost(Node node) {
        while (node.left != null) node = node.left;

        return node;
    }
}
