package day11;

/**
 * @author Heng Yu
 * @date 3/7/20 5:14 PM
 */

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 145: Binary Tree Postorder Traversal
 */

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        //edge case
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node.left != null) dfs(node.left, res);
        if (node.right != null) dfs(node.right, res);
        res.add(node.val);
    }
}
