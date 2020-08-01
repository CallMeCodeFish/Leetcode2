package newquestion.day63;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 7/31/20 3:50 PM
 */

/**
 * leetcode 669: Trim a binary search tree
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return helper(root, L, R);
    }

    private TreeNode helper(TreeNode node, int L, int R) {
        if (node == null) return null;

        if (node.val < L) {
            return helper(node.right, L, R);
        } else if (node.val > R) {
            return helper(node.left, L, R);
        } else {
            node.left = helper(node.left, L, R);
            node.right = helper(node.right, L, R);
            return node;
        }
    }
}
