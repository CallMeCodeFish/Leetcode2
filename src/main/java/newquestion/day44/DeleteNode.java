package newquestion.day44;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 6/28/20 8:08 PM
 */

/**
 * leetcode 450: Delete node in a BST
 */
public class DeleteNode {
    private TreeNode parent;
    private TreeNode cur;
    private boolean canFind;

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        parent = new TreeNode(0);
        parent.left = cur = root;
        TreeNode dummy = parent;
        canFind = false;

        searchNode(key);
        if (canFind) removeNode();

        return dummy.left;
    }

    private boolean isLeft() {
        return parent.left == cur;
    }

    private void removeNode() {
        if (cur.left == null && cur.right == null) {
            if (isLeft()) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (cur.left == null) {
            if (isLeft()) {
                parent.left = cur.right;
            } else {
                parent.right = cur.right;
            }
        } else if (cur.right == null) {
            if (isLeft()) {
                parent.left = cur.left;
            } else {
                parent.right = cur.left;
            }
        } else {
            TreeNode left = cur.left;
            cur.left = left.right;
            left.right = cur;
            if (isLeft()) {
                parent.left = left;
                parent = parent.left;
            } else {
                parent.right = left;
                parent = parent.right;
            }
            removeNode();
        }
    }

    private void searchNode(int target) {
        if (cur.val == target) {
            canFind = true;
            return;
        }

        if (target < cur.val) {
            if (cur.left != null) {
                parent = cur;
                cur = cur.left;
                searchNode(target);
            }
        } else {
            if (cur.right != null) {
                parent = cur;
                cur = cur.right;
                searchNode(target);
            }
        }
    }
}
