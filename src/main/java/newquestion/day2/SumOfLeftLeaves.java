package newquestion.day2;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 4/25/20 5:10 PM
 */

/**
 * leetcode 404: Sum of left leaves
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        //edge case
        if (root == null || root.left == null && root.right == null) return 0;

        return helper(root);
    }

    private int helper(TreeNode node) {
        int res = 0;
        if (node.left != null) {
            TreeNode left = node.left;
            if (left.left == null && left.right == null) {
                res += node.left.val;
            } else {
                res += helper(node.left);
            }
        }

        if (node.right != null) {
            res += helper(node.right);
        }

        return res;
    }
}
