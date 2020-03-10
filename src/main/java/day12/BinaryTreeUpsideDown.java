package day12;

/**
 * @author Heng Yu
 * @date 3/9/20 5:12 PM
 */

import helper.TreeNode;

/**
 * leetcode 156: Binary Tree Upside Down
 */

public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        //edge case
        if (root == null) return null;

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        return helper(left, right, root);
    }

    private TreeNode helper(TreeNode root, TreeNode left, TreeNode right) {
        //edge case
        if (root == null) return right;

        TreeNode nextRoot = root.left;
        TreeNode nextLeft = root.right;
        root.left = left;
        root.right = right;
        return helper(nextRoot, nextLeft, root);
    }
}
