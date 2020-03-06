package day9;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/5/20 5:03 PM
 */

/**
 * leetcode 113: Path Sum II
 */

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //edge case
        if (root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        backtrack(root, sum, res, new ArrayList<>());
        return res;
    }

    private void backtrack(TreeNode node, int sum, List<List<Integer>> res, List<Integer> cur) {
        //edge case
        sum -= node.val;
        cur.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<>(cur));
            }
        } else {
            if (node.left != null) backtrack(node.left, sum, res, cur);
            if (node.right != null) backtrack(node.right, sum, res, cur);
        }
        cur.remove(cur.size() - 1);
    }
}
