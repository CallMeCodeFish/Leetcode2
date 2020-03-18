package day20;

/**
 * @author Heng Yu
 * @date 3/17/20 3:32 PM
 */

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 257: Binary Tree Paths
 */

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        //edge case
        if (root == null) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        backtrack(root, res, new ArrayList<>());
        return res;
    }

    private void backtrack(TreeNode node, List<String> res, List<Integer> cur) {
        cur.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cur.size(); ++i) {
                sb.append(cur.get(i));
                if (i != cur.size() - 1) sb.append("->");
            }
            res.add(sb.toString());
        } else {
            if (node.left != null) {
                backtrack(node.left, res, cur);
            }
            if (node.right != null) {
                backtrack(node.right, res, cur);
            }
        }
        cur.remove(cur.size() - 1);
    }
}
