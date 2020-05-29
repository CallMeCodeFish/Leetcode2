package newquestion.day24;

import helper.TreeNode;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/28/20 2:45 PM
 */

/**
 * leetcode 1110: Delete nodes and return forest
 * Solution: two queues + bfs
 */
public class DeleteNodes {
    public static void main(String[] args) {
        DeleteNodes solution = new DeleteNodes();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(4);

        int[] nums = {3};

        List<TreeNode> result = solution.delNodes(root, nums);
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        //edge case
        if (root == null) return null;

        List<TreeNode> res = new ArrayList<>();

        Queue<TreeNode> roots = new LinkedList<>();
        roots.offer(root);

        Set<Integer> set = new HashSet<>();
        for (int num : to_delete) {
            set.add(num);
        }

        Queue<TreeNode> q = new LinkedList<>();

        while (!roots.isEmpty()) {
            int size = roots.size();
            for (int i = 0; i < size; i++) {
                root = roots.poll();
                if (set.contains(root.val)) {
                    if (root.left != null) roots.offer(root.left);
                    if (root.right != null) roots.offer(root.right);
                } else {
                    res.add(root);
                    q.offer(root);
                    bfs(q, roots, set);
                }
            }
        }

        return res;
    }

    private void bfs(Queue<TreeNode> q, Queue<TreeNode> roots, Set<Integer> set) {
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    if (set.contains(node.left.val)) {
                        roots.offer(node.left);
                        node.left = null;
                    } else {
                        q.offer(node.left);
                    }
                }

                if (node.right != null) {
                    if (set.contains(node.right.val)) {
                        roots.offer(node.right);
                        node.right = null;
                    } else {
                        q.offer(node.right);
                    }
                }
            }
        }
    }
}
