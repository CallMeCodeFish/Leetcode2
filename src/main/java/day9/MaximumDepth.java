package day9;

/**
 * @author Heng Yu
 * @date 3/5/20 3:01 PM
 */

import helper.TreeNode;

/**
 * leetcode 104: Maximum Depth of Binary Tree
 */

public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        //edge case
        if (node == null) return 0;

        return Math.max(helper(node.left), helper(node.right)) + 1;
    }
}
