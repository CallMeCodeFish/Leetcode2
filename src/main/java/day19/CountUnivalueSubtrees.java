package day19;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 3/16/20 6:11 PM
 */

/**
 * leetcode 250: Count Univalue Subtrees
 */

public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        //edge case
        if (root == null) return 0;

        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private boolean dfs(TreeNode node, int[] res) {
        if (node.left == null && node.right == null) {
            ++res[0];
            return true;
        } else if (node.left == null) {
            boolean right = dfs(node.right, res);
            if (right && node.val == node.right.val) {
                ++res[0];
                return true;
            }
            return false;
        } else if (node.right == null) {
            boolean left = dfs(node.left, res);
            if (left && node.val == node.left.val) {
                ++res[0];
                return true;
            }
            return false;
        } else {
            boolean left = dfs(node.left, res);
            boolean right = dfs(node.right, res);
            if (left && right && node.left.val == node.right.val && node.val == node.left.val) {
                ++res[0];
                return true;
            }
            return false;
        }
    }
}
