package newquestion.day64;

import helper.TreeNode;

/**
 * @author Tim
 * @date 8/1/20 5:29 PM
 */

/**
 * leetcode 1008: Construct binary search tree from preorder traversal
 */
public class ConstructBSTFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length);
    }

    private TreeNode helper(int[] pre, int start, int end) {
        if (start == end) return null;

        TreeNode node = new TreeNode(pre[start]);

        int mid = search(pre, start + 1, end, pre[start]);

        node.left = helper(pre, start + 1, mid);
        node.right = helper(pre, mid, end);

        return node;
    }

    private int search(int[] nums, int l, int r, int target) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
