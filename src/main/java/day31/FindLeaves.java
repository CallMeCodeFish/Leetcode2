package day31;

/**
 * @author Heng Yu
 * @date 4/7/20 6:43 PM
 */

import helper.TreeNode;

import java.util.*;

/**
 * leetcode 366: Find Leaves of Binary Tree
 */

public class FindLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        //edge case
        if (root == null) return new ArrayList<>();


        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private int helper(TreeNode node, List<List<Integer>> res) {
        //edge case
        if (node.left == null && node.right == null) {
            if (res.isEmpty()) {
                res.add(new ArrayList<>());
            }
            res.get(0).add(node.val);
            return 0;
        }

        int left = 0;
        if (node.left != null) {
            left = helper(node.left, res) + 1;
        }
        int right = 0;
        if (node.right != null) {
            right = helper(node.right, res) + 1;
        }
        int max = Math.max(left, right);
        if (res.size() - 1 < max) {
            res.add(new ArrayList<>());
        }
        res.get(max).add(node.val);
        return max;
    }
}
