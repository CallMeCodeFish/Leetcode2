package day22;

/**
 * @author Heng Yu
 * @date 3/19/20 4:01 PM
 */

import helper.TreeNode;

/**
 * leetcode 285: Inorder Successor in BST
 */

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return helper(root, p);
    }

    private TreeNode helper(TreeNode node, TreeNode target) {
        //edge case
        if (node == null) return null;

        TreeNode res = null;
        if (target.val < node.val) {
            res = helper(node.left, target);
            if (res == null) res = node;
        } else {
            res = helper(node.right, target);
        }
        return res;
    }
}
