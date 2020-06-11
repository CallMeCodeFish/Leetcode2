package newquestion.day33;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 6/10/20 5:08 PM
 */

/**
 * leetcode 99: Recover binary search tree
 */
public class RecoverBST {
    public static void main(String[] args) {
        RecoverBST solution = new RecoverBST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        solution.recoverTree(root);
    }

    private TreeNode pred = null;
    private TreeNode maxNode = null;
    private TreeNode minNode = null;

    public void recoverTree(TreeNode root) {
        preOrder(root);

        int temp = maxNode.val;
        maxNode.val = minNode.val;
        minNode.val = temp;
    }

    private void preOrder(TreeNode node) {
        if (node.left != null) preOrder(node.left);

        if (pred != null) {
            if (node.val < pred.val) {
                minNode = node;
                if (maxNode == null) {
                    maxNode = pred;
                }
            }
        }
        pred = node;

        if (node.right != null) preOrder(node.right);
    }
}
