package day9;

/**
 * @author Heng Yu
 * @date 3/5/20 4:33 PM
 */

import helper.TreeNode;

/**
 * leetcode 112: Path Sum
 */

public class PathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        PathSum solution = new PathSum();
        boolean result = solution.hasPathSum(root, -5);
        System.out.println(result);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        //edge case
        if (root == null) return false;

        return helper(root, sum);
    }

    private boolean helper(TreeNode node, int sum) {
        sum -= node.val;

        if (node.left == null && node.right == null) {
            return sum == 0;
        } else if (node.left == null) {
            return helper(node.right, sum);
        } else if (node.right == null) {
            return helper(node.left, sum);
        } else {
            return helper(node.left, sum) || helper(node.right, sum);
        }
    }
}
