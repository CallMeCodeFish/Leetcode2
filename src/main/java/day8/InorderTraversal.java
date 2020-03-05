package day8;

/**
 * @author Heng Yu
 * @date 3/4/20 6:21 PM
 */

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 94: Binary Tree Inorder Traversal
 */

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        //edge case
        if (node == null) return;

        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }
}
