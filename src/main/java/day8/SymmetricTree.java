package day8;

/**
 * @author Heng Yu
 * @date 3/4/20 8:35 PM
 */

import helper.TreeNode;

/**
 * leetcode 101: Symmetric Tree
 */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        //edge case
        if (root == null) return true;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        //edge case
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;
        return helper(p.left, q.right) && helper(p.right, q.left);
    }
}
