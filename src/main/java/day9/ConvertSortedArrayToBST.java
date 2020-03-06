package day9;

/**
 * @author Heng Yu
 * @date 3/5/20 3:41 PM
 */

import helper.TreeNode;

/**
 * leetcode 108: Convert Sorted Array to Binary Search Tree
 */

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return null;

        return helper(nums, 0, nums.length);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        //edge case
        if (l == r) return null;

        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, l, mid);
        node.right = helper(nums, mid + 1, r);
        return node;
    }
}
