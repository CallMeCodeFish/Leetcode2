package day11;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/7/20 5:11 PM
 */

/**
 * leetcode 144: Binary Tree Preorder Traversal
 */

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        //edge case
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        res.add(node.val);
        if (node.left != null) dfs(node.left, res);
        if (node.right != null) dfs(node.right, res);
    }
}
