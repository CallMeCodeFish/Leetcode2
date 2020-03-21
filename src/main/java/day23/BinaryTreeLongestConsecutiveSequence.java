package day23;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 3/20/20 3:13 PM
 */

/**
 * leetcode 298: Binary Tree Longest Consecutive Sequence
 */

public class BinaryTreeLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        //edge case
        if (root == null) return 0;

        return helper(root, 0, 0);
    }

    private int helper(TreeNode node, int max, int cur) {
        ++cur;
        max = Math.max(max, cur);
        if (node.left != null) {
            int left = 0;
            if (node.val + 1 == node.left.val) {
                left = helper(node.left, max, cur);
            } else {
                left = helper(node.left, max, 0);
            }
            max = Math.max(max, left);
        }
        if (node.right != null) {
            int right = 0;
            if (node.val + 1 == node.right.val) {
                right = helper(node.right, max, cur);
            } else {
                right = helper(node.right, max, 0);
            }
            max = Math.max(max, right);
        }
        return max;
    }
}
