package day18;

/**
 * @author Heng Yu
 * @date 3/15/20 5:26 PM
 */

import helper.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 236: Lowest Common Ancestor of a Binary Tree
 */

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList<>();
        backtrack(root, p, l1);
        List<TreeNode> l2 = new ArrayList<>();
        backtrack(root, q, l2);
        Set<TreeNode> set = new HashSet<>(l1);
        TreeNode res = null;
        for (int i = l2.size() - 1; i >= 0; --i) {
            if (set.contains(l2.get(i))) {
                res = l2.get(i);
                break;
            }
        }
        return res;
    }

    private boolean backtrack(TreeNode node, TreeNode target, List<TreeNode> list) {
        list.add(node);
        if (node.val != target.val) {
            if (node.left != null) {
                if (backtrack(node.left, target, list)) return true;
            }
            if (node.right != null) {
                if (backtrack(node.right, target, list)) return true;
            }
        } else {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }

    /**
     * 第一遍的solution，runtime更短
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (p.val == root.val || q.val == root.val) return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        return root;
    }
}
