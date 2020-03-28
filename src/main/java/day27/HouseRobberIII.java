package day27;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 3/27/20 8:10 PM
 */

/**
 * leetcode 337: House Robber III
 */

public class HouseRobberIII {
    public int rob(TreeNode root) {
        //edge case
        if (root == null) return 0;

        int[] gains = new int[2];
        dfs(root, gains);
        return Math.max(gains[0], gains[1]);
    }

    private void dfs(TreeNode node, int[] gains) {
        if (node.left == null && node.right == null) {
            gains[0] = 0;
            gains[1] = node.val;
        } else if (node.left == null) {
            dfs(node.right, gains);
            int notRob = Math.max(gains[0], gains[1]);
            int rob = gains[0] + node.val;
            gains[0] = notRob;
            gains[1] = rob;
        } else if (node.right == null) {
            dfs(node.left, gains);
            int notRob = Math.max(gains[0], gains[1]);
            int rob = gains[0] + node.val;
            gains[0] = notRob;
            gains[1] = rob;
        } else {
            dfs(node.left, gains);
            int notRobLeft = gains[0];
            int robLeft = gains[1];
            dfs(node.right, gains);
            int notRob = Math.max(notRobLeft, robLeft) + Math.max(gains[0], gains[1]);
            int rob = node.val + notRobLeft + gains[0];
            gains[0] = notRob;
            gains[1] = rob;
        }
    }
}
