package day8;

/**
 * @author Heng Yu
 * @date 3/4/20 9:20 PM
 */

import helper.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 103: Binary Tree Zigzag Level Order Traversal
 */

public class ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //edge case
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        boolean fromLeft = true;
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            if (fromLeft) {
                for (int i = 0; i < size; ++i) {
                    TreeNode node = deque.pollFirst();
                    list.add(node.val);
                    if (node.left != null) deque.offerLast(node.left);
                    if (node.right != null) deque.offerLast(node.right);
                }
                fromLeft = false;
            } else {
                for (int i = 0; i < size; ++i) {
                    TreeNode node = deque.pollLast();
                    list.add(node.val);
                    if (node.right != null) deque.offerFirst(node.right);
                    if (node.left != null) deque.offerFirst(node.left);
                }
                fromLeft = true;
            }
            res.add(list);
        }
        return res;
    }
}
