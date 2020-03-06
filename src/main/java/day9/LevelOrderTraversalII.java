package day9;

/**
 * @author Heng Yu
 * @date 3/5/20 3:32 PM
 */

import helper.TreeNode;

import java.util.*;

/**
 * leetcode 107: Binary Tree Level Order Traversal II
 */

public class LevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //edge case
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(list);
        }
        Collections.reverse(res);
        return res;
    }
}
