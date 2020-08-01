package newquestion.day64;

import helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Tim
 * @date 8/1/20 5:52 PM
 */

/**
 * leetcode 1123: Lowest common ancestor of deepest leaves
 */
public class LowestCommAncestor {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();

        calculateHeight(root, map);

        return helper(root, map);
    }

    private TreeNode helper(TreeNode node, Map<TreeNode, Integer> map) {
        int left = node.left == null ? -1 : map.get(node.left);
        int right = node.right == null ? - 1 : map.get(node.right);

        if (left == right) return node;

        return left < right ? helper(node.right, map) : helper(node.left, map);
    }

    private int calculateHeight(TreeNode node, Map<TreeNode, Integer> map) {
        if (node == null) return -1;

        int left = calculateHeight(node.left, map);
        int right = calculateHeight(node.right, map);

        int res = Math.max(left, right) + 1;
        map.put(node, res);

        return res;
    }
}
