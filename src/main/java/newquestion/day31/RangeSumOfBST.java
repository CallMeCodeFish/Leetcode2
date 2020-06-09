package newquestion.day31;

/**
 * @author Heng Yu
 * @date 6/8/20 3:55 PM
 */

import helper.TreeNode;

/**
 * leetcode 938: Range sum of BST
 */
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        return dfs(root, L, R);
    }

    private int dfs(TreeNode node, int min, int max) {
        //edge case
        if (node == null || min > max) return 0;

        int res = 0;

        if (node.val > max) {
            res = dfs(node.left, min, max);
        } else if (node.val < min) {
            res = dfs(node.right, min, max);
        } else {
            res += node.val;
            res += dfs(node.left, min, node.val - 1);
            res += dfs(node.right, node.val + 1, max);
        }

        return res;
    }
}
