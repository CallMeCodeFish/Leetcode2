package contest.mar14;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/14/20 11:00 PM
 */

/**
 * leetcode 1382: Balance a Binary Search Tree
 */

public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        traverse(root, nums);
        return construct(nums, 0, nums.size());
    }

    private TreeNode construct(List<Integer> nums, int l, int r) {
        //edge case
        if (l == r) return null;

        int mid = l + (r - l) / 2;
        int value = nums.get(mid);
        TreeNode node = new TreeNode(value);
        node.left = construct(nums, l, mid);
        node.right = construct(nums, mid + 1, r);
        return node;
    }

    private void traverse(TreeNode node, List<Integer> nums) {
        if (node.left != null) {
            traverse(node.left, nums);
        }
        nums.add(node.val);
        if (node.right != null) {
            traverse(node.right, nums);
        }
    }
}
