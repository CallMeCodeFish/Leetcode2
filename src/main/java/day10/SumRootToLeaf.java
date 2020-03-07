package day10;

/**
 * @author Heng Yu
 * @date 3/6/20 8:11 PM
 */

import helper.TreeNode;

/**
 * leetcode 129: Sum Root to Leaf Numbers
 */

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        //edge case
        if (root == null) return 0;

        return helper(root, 0);
    }

    private int helper(TreeNode node, int cur) {
        //edge case
        cur = cur * 10 + node.val;
        if (node.left == null && node.right == null) return cur;

        int sum = 0;
        if (node.left != null) {
            sum += helper(node.left, cur);
        }
        if (node.right != null) {
            sum += helper(node.right, cur);
        }
        return sum;
    }
}
