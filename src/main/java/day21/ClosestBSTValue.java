package day21;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 3/18/20 7:17 PM
 */

/**
 * leetcode 270: Closest Binary Search Tree Value
 */

public class ClosestBSTValue {
    public int closestValue(TreeNode root, double target) {
        return helper(root, target, 0, Double.POSITIVE_INFINITY);
    }

    private int helper(TreeNode node, double target, int res, double dif) {
        double newDif = Math.abs(target - node.val);
        if (newDif == 0) return node.val;
        if (newDif < dif) {
            res = node.val;
            dif = newDif;
        }
        if (target < node.val) {
            if (node.left == null) return res;
            return helper(node.left, target, res, dif);
        } else {
            if (node.right == null) return res;
            return helper(node.right, target, res, dif);
        }
    }
}
