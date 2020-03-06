package day9;

/**
 * @author Heng Yu
 * @date 3/5/20 8:48 PM
 */

import helper.TreeNode;

/**
 * leetcode 114: Flatten Binary Tree to Linked List
 */

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        //edge case
        if (root == null) return;

        helper(root);
    }

    private TreeNode helper(TreeNode node) {
        if (node.left != null) {
            if (node.right != null) {
                TreeNode right = node.right;
                node.right = node.left;
                node.left = null;
                TreeNode last = helper(node.right);
                last.right = right;
                last = helper(last.right);
                return last;
            } else {
                node.right = node.left;
                node.left = null;
                return helper(node.right);
            }
        } else {
            if (node.right != null) {
                return helper(node.right);
            } else {
                return node;
            }
        }
    }
}
