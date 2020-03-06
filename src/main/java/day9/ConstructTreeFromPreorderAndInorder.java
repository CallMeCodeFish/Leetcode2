package day9;

/**
 * @author Heng Yu
 * @date 3/5/20 3:05 PM
 */

import helper.TreeNode;

/**
 * leetcode 105: Construct Binary Tree from Preorder and Inorder
 */

public class ConstructTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode helper(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        //edge case
        if (preLeft == preRight) return null;

        int val = preorder[preLeft];
        TreeNode node = new TreeNode(val);
        int j = inLeft;
        while (j < inRight) {
            if (val == inorder[j]) break;
            ++j;
        }
        int leftSize = j - inLeft;
        int i = preLeft + 1;
        node.left = helper(preorder, i, i + leftSize, inorder, inLeft, j);
        node.right = helper(preorder, i + leftSize, preRight, inorder, j + 1, inRight);
        return node;
    }
}
