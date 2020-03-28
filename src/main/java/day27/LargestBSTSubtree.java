package day27;

/**
 * @author Heng Yu
 * @date 3/27/20 5:41 PM
 */

import helper.TreeNode;

/**
 * leetcode 333: Largest BST Subtree
 */

public class LargestBSTSubtree {
    public static void main(String[] args) {
        LargestBSTSubtree solution = new LargestBSTSubtree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        int result = solution.largestBSTSubtree(root);
        System.out.println(result);
    }

    public int largestBSTSubtree(TreeNode root) {
        //edge case
        if (root == null) return 0;

        int[] res = new int[]{0};
        dfs(root, res, new int[]{0}, new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE});
        return res[0];
    }

    private boolean dfs(TreeNode node, int[] res, int[] cur, int[] range) {
        if (node.left == null && node.right == null) {
            cur[0] = 1;
            res[0] = Math.max(res[0], cur[0]);
            range[0] = range[1] = node.val;
            return true;
        } else if (node.left == null) {
            boolean right = dfs(node.right, res, cur, range);
            boolean result = false;
            if (right && node.val < range[0]) {
                result = true;
                ++cur[0];
                range[0] = node.val;
            }
            res[0] = Math.max(res[0], cur[0]);
            return result;
        } else if (node.right == null) {
            boolean left = dfs(node.left, res, cur, range);
            boolean result = false;
            if (left && range[1] < node.val) {
                result = true;
                ++cur[0];
                range[1] = node.val;
            }
            res[0] = Math.max(res[0], cur[0]);
            return result;
        } else {
            boolean left = dfs(node.left, res, cur, range);
            int curLeft = cur[0];
            int minLeft = range[0];
            int maxLeft = range[1];
            boolean right = dfs(node.right, res, cur, range);
            boolean result = false;
            if (left && right && maxLeft < node.val && node.val < range[0]) {
                result = true;
                cur[0] += curLeft + 1;
                range[0] = minLeft;
            }
            res[0] = Math.max(res[0], cur[0]);
            return result;
        }
    }
}
