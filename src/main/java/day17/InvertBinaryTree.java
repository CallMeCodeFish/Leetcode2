package day17;

/**
 * @author Heng Yu
 * @date 3/14/20 6:48 PM
 */

import helper.TreeNode;

/**
 * leetcode 226: Invert Binary Tree
 */

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        //edge case
        if (root == null) return null;

        helper(root);
        return root;
    }

    private void helper(TreeNode node) {
        TreeNode right = node.right;
        node.right = node.left;
        node.left = right;
        if (node.left != null) helper(node.left);
        if (node.right != null) helper(node.right);
    }
}
