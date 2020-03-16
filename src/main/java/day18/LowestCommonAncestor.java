package day18;

/**
 * @author Heng Yu
 * @date 3/15/20 4:56 PM
 */

import helper.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 235: Lowest Common Ancestor of a Binary Search Tree
 */

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        helper(root, p, list1);
        List<TreeNode> list2 = new ArrayList<>();
        helper(root, q, list2);
        Set<TreeNode> set = new HashSet<>(list1);
        TreeNode res = null;
        for (int i = list2.size() - 1; i >= 0; --i) {
            if (set.contains(list2.get(i))) {
                res = list2.get(i);
                break;
            }
        }
        return res;
    }

    private void helper(TreeNode node, TreeNode target, List<TreeNode> list) {
        list.add(node);
        if (target.val < node.val) {
            helper(node.left, target, list);
        } else if (node.val < target.val) {
            helper(node.right, target, list);
        }
    }
}
