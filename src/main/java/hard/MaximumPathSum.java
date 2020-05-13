package hard;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 5/12/20 7:51 PM
 */

/**
 * leetcode 124: Binary tree maximum path sum
 */
public class MaximumPathSum {
    private int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;

        dfs(root);

        return max;
    }

    private int dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            max = Math.max(max, node.val);
            return node.val;
        } else if (node.left == null) {
            int right = dfs(node.right);
            int res = Math.max(node.val, node.val + right);
            max = Math.max(max, res);
            return res;
        } else if (node.right == null) {
            int left = dfs(node.left);
            int res = Math.max(node.val, node.val + left);
            max = Math.max(max, res);
            return res;
        } else {
            int left = dfs(node.left);
            int right = dfs(node.right);
            int res = Math.max(node.val, Math.max(node.val + left, node.val + right));
            max = Math.max(max, Math.max(res, node.val + left + right));
            return res;
        }
    }
}
