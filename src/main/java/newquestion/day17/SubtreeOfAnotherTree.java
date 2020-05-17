package newquestion.day17;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 5/16/20 3:19 PM
 */

/**
 * leetcode 572: Subtree of another tree
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<TreeNode> list = new ArrayList<>();

        findRoot(s, t.val, list);

        for (TreeNode node : list) {
            if (helper(node, t)) return true;
        }

        return false;
    }

    private boolean helper(TreeNode s, TreeNode t) {
        if (s.left == null && t.left != null || s.left != null && t.left == null || s.right == null && t.right != null || s.right != null && t.right == null) return false;

        if (s.left != null) {
            if (s.left.val != t.left.val || !helper(s.left, t.left)) return false;
        }

        if (s.right != null) {
            if (s.right.val != t.right.val || !helper(s.right, t.right)) return false;
        }

        return true;
    }

    private void findRoot(TreeNode node, int val, List<TreeNode> list) {
        if (val == node.val) list.add(node);

        if (node.left != null) findRoot(node.left, val, list);

        if (node.right != null) findRoot(node.right, val, list);
    }
}
