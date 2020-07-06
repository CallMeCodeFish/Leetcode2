package newquestion.day48;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 7/5/20 3:43 PM
 */

/**
 * leetcode 617: Merge two binary trees
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1, t2);
    }

    private TreeNode merge(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        TreeNode res = new TreeNode();

        if (t1 == null) {
            res.val = t2.val;
            res.left = merge(null, t2.left);
            res.right = merge(null, t2.right);
        } else if (t2 == null) {
            res.val = t1.val;
            res.left = merge(t1.left, null);
            res.right = merge(t1.right, null);
        } else {
            res.val = t1.val + t2.val;
            res.left = merge(t1.left, t2.left);
            res.right = merge(t1.right, t2.right);
        }

        return res;
    }
}
