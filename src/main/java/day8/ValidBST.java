package day8;

/**
 * @author Heng Yu
 * @date 3/4/20 7:56 PM
 */

import helper.TreeNode;

/**
 * leetcode 98: Valid Binary Search Tree
 */

public class ValidBST {
    public static void main(String[] args) {
        ValidBST solution = new ValidBST();
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        root.left = new TreeNode(Integer.MIN_VALUE);
        boolean result = solution.isValidBST(root);
        System.out.println(result);
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long min, long max) {
        //edge case
        if (node == null) return true;
        long val = node.val;
        if (val < min || max < val) return false;

        return dfs(node.left, min, val - 1) && dfs(node.right, val + 1, max);
    }
}
