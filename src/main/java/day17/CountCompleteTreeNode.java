package day17;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heng Yu
 * @date 3/14/20 5:57 PM
 */


public class CountCompleteTreeNode {
    public int countNodes(TreeNode root) {
        //edge case
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.poll();
                ++res;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return res;
    }

    public int countNodes2(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        return 1 + dfs(node.left) + dfs(node.right);
    }
}
