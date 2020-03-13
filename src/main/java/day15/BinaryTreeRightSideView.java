package day15;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/12/20 9:22 PM
 */


public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        //edge case
        if (root == null) return new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isRight = false;
            for (int i = 0; i < size; ++i) {
                TreeNode poll = queue.poll();
                if (!isRight) {
                    res.add(poll.val);
                    isRight = true;
                }
                if (poll.right != null) queue.offer(poll.right);
                if (poll.left != null) queue.offer(poll.left);
            }
        }
        return res;
    }
}
