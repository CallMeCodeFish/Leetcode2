package newquestion.day15;

import helper.TreeNode;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/13/20 3:37 PM
 */

/**
 * leetcode 863: All nodes distance K in binary tree
 */
public class AllNodesDistance {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();

        //edge case
        if (K == 0) {
            res.add(target.val);
            return res;
        }

        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode parent = q.poll();
            if (parent.val == target.val) break;

            if (parent.left != null) {
                map.put(parent.left, parent);
                q.offer(parent.left);
            }

            if (parent.right != null) {
                map.put(parent.right, parent);
                q.offer(parent.right);
            }
        }

        helper(target, K, res);

        TreeNode parent = map.get(target);
        TreeNode cur = target;

        while (parent != null) {
            if (--K == 0) {
                res.add(parent.val);
                break;
            }
            if (parent.left != null && cur.val == parent.left.val) {
                if (parent.right != null) helper(parent.right, K - 1, res);
            } else {
                if (parent.left != null) helper(parent.left, K - 1, res);
            }

            cur = parent;
            parent = map.get(cur);
        }

        return res;
    }

    private void helper(TreeNode node, int d, List<Integer> res) {
        if (d == 0) {
            res.add(node.val);
            return;
        }

        if (node.left != null) {
            helper(node.left, d - 1, res);
        }

        if (node.right != null) {
            helper(node.right, d - 1, res);
        }
    }
}
