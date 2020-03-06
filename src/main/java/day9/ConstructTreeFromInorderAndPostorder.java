package day9;

/**
 * @author Heng Yu
 * @date 3/5/20 3:22 PM
 */

import helper.TreeNode;

/**
 * leetcode 106: Construct Binary Tree from Inorder and Postorder
 */

public class ConstructTreeFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode helper(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        //edge case
        if (inLeft == inRight) return null;

        int val = postorder[postRight - 1];
        TreeNode node = new TreeNode(val);
        int i = inLeft;
        while (i < inRight) {
            if (inorder[i] == val) break;
            ++i;
        }
        int leftSize = i - inLeft;
        node.left = helper(inorder, inLeft, i, postorder, postLeft, postLeft + leftSize);
        node.right = helper(inorder, i + 1, inRight, postorder, postLeft + leftSize, postRight - 1);
        return node;
    }
}
