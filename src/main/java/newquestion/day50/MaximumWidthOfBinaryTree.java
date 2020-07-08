package newquestion.day50;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heng Yu
 * @date 7/7/20 6:08 PM
 */

/**
 * leetcode 662: Maximum width of binary tree
 * solution: level-order traversal + prefix count
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int res = 0;
        TreeNode dummy = new TreeNode();
        Queue<TreeNode> node = new LinkedList<>();
        Queue<Integer> prefix = new LinkedList<>();
        node.offer(root);
        prefix.offer(0);

        while (!node.isEmpty()) {
            int size = node.size();
            int j = prefix.peek();
            for (int i = 0; i < size; i++) {
                TreeNode cur = node.poll();
                int op = prefix.poll();

                if (i == size - 1) {
                    res = Math.max(res, op - j + 1);
                }

                int np = op * 2;
                if (cur.left != null) {
                    node.offer(cur.left);
                    prefix.offer(np);
                }

                if (cur.right != null) {
                    node.offer(cur.right);
                    prefix.offer(np + 1);
                }
            }
        }


        return res;
    }
}
