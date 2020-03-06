package day9;

/**
 * @author Heng Yu
 * @date 3/5/20 4:05 PM
 */

import helper.TreeNode;

/**
 * leetcode 110: Balanced Binary Tree
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        //edge case
        if (node == null) return 0;

        int left = helper(node.left);
        if (left < 0) return -1;
        int right = helper(node.right);
        if (right < 0) return -1;
        if (1 < Math.abs(left - right)) return -1;
        return 1 + Math.max(left, right);
    }
}
