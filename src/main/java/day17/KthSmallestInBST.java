package day17;

/**
 * @author Heng Yu
 * @date 3/14/20 9:33 PM
 */

import helper.TreeNode;

/**
 * leetcode 230: Kth Smallest Element in BST
 */

public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        int[] memo = new int[k];
        dfs(root, 0, memo);
        return memo[k - 1];
    }

    private int dfs(TreeNode node, int i, int[] memo) {
        //edge case
        if (i == memo.length) return i;

        if (node.left != null) {
            i = dfs(node.left, i, memo);
        }
        if (i < memo.length) {
            memo[i++] = node.val;
            if (node.right != null) {
                i = dfs(node.right, i, memo);
            }
        }
        return i;
    }
}
