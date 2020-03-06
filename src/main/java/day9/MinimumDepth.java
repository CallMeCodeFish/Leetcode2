package day9;

/**
 * @author Heng Yu
 * @date 3/5/20 4:25 PM
 */

import helper.TreeNode;

/**
 * leetcode 111: Minimum Depth of Binary Tree
 */

public class MinimumDepth {
    public int minDepth(TreeNode root) {
        //edge case
        if (root == null) return 0;

        return helper(root);
    }

    private int helper(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 1;
        } else if (node.left == null) {
            return 1 + helper(node.right);
        } else if (node.right == null) {
            return 1 + helper(node.left);
        } else {
            return 1 + Math.min(helper(node.left), helper(node.right));
        }
    }
}
