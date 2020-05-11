package newquestion.day13;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 5/11/20 3:45 PM
 */

/**
 * leetcode 543: Diameter of binary tree
 */
public class DiameterOfBinaryTree {
    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    private int helper(TreeNode node) {
        //edge case
        if (node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
