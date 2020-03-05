package day8;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/4/20 6:34 PM
 */

/**
 * leetcode 95: Unique Binary Search Tree II
 */

public class UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1, n + 1);
    }

    private List<TreeNode> dfs(int l, int r) {
        //edge case
        if (l == r) {
            return new ArrayList<>();
        }

        List<TreeNode> res = new ArrayList<>();
        for (int i = l; i < r; ++i) {
            List<TreeNode> lefts = dfs(l, i);
            List<TreeNode> rights = dfs(i + 1, r);
            if (!lefts.isEmpty() && !rights.isEmpty()) {
                for (TreeNode left : lefts) {
                    for (TreeNode right : rights) {
                        TreeNode node = new TreeNode(i);
                        node.left = left;
                        node.right = right;
                        res.add(node);
                    }
                }
            } else if (!lefts.isEmpty()) {
                for (TreeNode left : lefts) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    res.add(node);
                }
            } else if (!rights.isEmpty()) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.right = right;
                    res.add(node);
                }
            } else {
                res.add(new TreeNode(i));
            }
        }
        return res;
    }
}
