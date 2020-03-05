package day8;

/**
 * @author Heng Yu
 * @date 3/4/20 8:30 PM
 */

import helper.TreeNode;

/**
 * leetcode 100: Same Tree
 */

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        //edge case
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;
        return dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}
