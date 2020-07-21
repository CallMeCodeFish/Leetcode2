package newquestion.day58;

import helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 7/20/20 5:34 PM
 */

/**
 * leetcode 979: Distribute coins in binary tree
 * ref: https://leetcode.com/problems/distribute-coins-in-binary-tree/discuss/221930/JavaC%2B%2BPython-Recursive-Solution
 */
public class DistributeCoins {
    //method 1 (from discuss)
    private int res = 0;
    public int distributeCoins(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        int left = helper(node.left);
        int right = helper(node.right);
        res += Math.abs(left) + Math.abs(right);

        return left + right + node.val - 1;
    }

    //method 2
    private int res2 = 0;
    public int distributeCoins2(TreeNode root) {
        Map<TreeNode, Integer> own = new HashMap<>();
        Map<TreeNode, Integer> require = new HashMap<>();

        count(root, own, require);

        helper(root, own, require);

        return res2;
    }

    private void helper(TreeNode node, Map<TreeNode, Integer> own, Map<TreeNode, Integer> require) {
        if (node.left == null && node.right == null) {
            return;
        } else if (node.left == null) {
            if (node.val != 1) {
                res2++;
                int diff = node.val - 1;
                node.val = 1;
                node.right.val += diff;
            }
            helper(node.right, own, require);
        } else if (node.right == null) {
            if (node.val != 1) {
                res2++;
                int diff = node.val - 1;
                node.val = 1;
                node.left.val += diff;
            }
            helper(node.left, own, require);
        } else {
            int diff = node.val - 1;
            if (diff == 0) {
                int leftDiff = own.get(node.left) - require.get(node.left);
                if (leftDiff != 0) {
                    res2 += 2;
                    node.left.val -= leftDiff;
                    node.right.val += leftDiff;
                }
            } else {
                int leftDiff = own.get(node.left) - require.get(node.left);
                if (leftDiff == 0) {
                    res2++;
                    node.val = 1;
                    node.right.val += diff;
                } else {
                    int rightDiff = own.get(node.right) - require.get(node.right);
                    if (rightDiff == 0) {
                        res2++;
                        node.val = 1;
                        node.left.val -= leftDiff;
                    } else {
                        res2 += 2;
                        node.val = 1;
                        node.left.val -= leftDiff;
                        node.right.val -= rightDiff;
                    }
                }
            }

            helper(node.left, own, require);
            helper(node.right, own, require);
        }
    }

    private void count(TreeNode node, Map<TreeNode, Integer> own, Map<TreeNode, Integer> require) {
        int o = node.val;
        int r = 1;

        if (node.left != null) {
            count(node.left, own, require);
            o += own.get(node.left);
            r += require.get(node.left);
        }

        if (node.right != null) {
            count(node.right, own, require);
            o += own.get(node.right);
            r += require.get(node.right);
        }

        own.put(node, o);
        require.put(node, r);
    }
}
