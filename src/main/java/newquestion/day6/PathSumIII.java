package newquestion.day6;

import helper.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 5/1/20 9:23 PM
 */

/**
 * leetcode 437: Path Sum III
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);
        return helper(root, sum, 0, visited);
    }

    private int helper(TreeNode node, int sum, int cur, Set<TreeNode> visited) {
        int res = 0;

        int next = node.val + cur;
        if (next == sum) {
            ++res;
        }

        if (node.left != null) {
            res += helper(node.left, sum, next, visited);
            if (!visited.contains(node.left)) {
                visited.add(node.left);
                res += helper(node.left, sum, 0, visited);
            }
        }

        if (node.right != null) {
            res += helper(node.right, sum, next, visited);
            if (!visited.contains(node.right)) {
                visited.add(node.right);
                res += helper(node.right, sum, 0, visited);
            }
        }

        return res;
    }
}
