package day14;

/**
 * @author Heng Yu
 * @date 3/11/20 3:05 PM
 */

import helper.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * leetcode 173: Binary Search Tree Iterator
 */

public class BSTIterator {
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new ArrayDeque<>();
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode top = stack.pop();
        if (top.right != null) {
            TreeNode cur = top.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return top.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
