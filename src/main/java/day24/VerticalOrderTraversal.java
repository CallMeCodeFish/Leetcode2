package day24;

import helper.TreeNode;

import java.util.*;

/**
 * @author Heng Yu
 * @date 3/21/20 9:58 PM
 */

/**
 * leetcode 314: Binary Tree Vertical Order Traversal
 */

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        //edge case
        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> lists = new HashMap<>();
        Map<TreeNode, Integer> levels = new HashMap<>();
        lists.put(0, new ArrayList<>());
        lists.get(0).add(root.val);
        levels.put(root, 0);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                int level = levels.get(node);
                if (node.left != null) {
                    if (!lists.containsKey(level - 1)) {
                        lists.put(level - 1, new ArrayList<>());
                    }
                    lists.get(level - 1).add(node.left.val);
                    levels.put(node.left, level - 1);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    if (!lists.containsKey(level + 1)) {
                        lists.put(level + 1, new ArrayList<>());
                    }
                    lists.get(level + 1).add(node.right.val);
                    levels.put(node.right, level + 1);
                    q.offer(node.right);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : lists.keySet()) {
            if (max < n) max = n;
            if (n < min) min = n;
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; ++i) {
            res.add(lists.get(i));
        }
        return res;
    }
}
