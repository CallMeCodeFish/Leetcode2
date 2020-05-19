package newquestion.day18;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Heng Yu
 * @date 5/18/20 3:22 PM
 */

/**
 * leetcode 545: Boundary of binary tree
 */
public class BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();

        res.add(root.val);

        if (root.left != null) {
            List<Integer> left = new ArrayList<>();
            findLeftBoundary(root.left, left);
            res.addAll(left);
        }

        List<Integer> leaves = new ArrayList<>();
        if (root.left != null) findLeaves(root.left, leaves);
        if (root.right != null) findLeaves(root.right, leaves);
        res.addAll(leaves);

        if (root.right != null) {
            List<Integer> right = new ArrayList<>();
            findRightBoundary(root.right, right);
            Collections.reverse(right);
            res.addAll(right);
        }

        return res;
    }

    private void findRightBoundary(TreeNode node, List<Integer> res) {
        if (node.left == null && node.right == null) return;

        res.add(node.val);
        if (node.right != null) {
            findRightBoundary(node.right, res);
        } else {
            findRightBoundary(node.left, res);
        }
    }

    private void findLeaves(TreeNode node, List<Integer> res) {
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }

        if (node.left != null) findLeaves(node.left, res);

        if (node.right != null) findLeaves(node.right, res);
    }

    private void findLeftBoundary(TreeNode node, List<Integer> res) {
        if (node.left == null && node.right == null) return;

        res.add(node.val);
        if (node.left != null) {
            findLeftBoundary(node.left, res);
        } else {
            findLeftBoundary(node.right, res);
        }
    }
}
