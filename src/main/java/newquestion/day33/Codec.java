package newquestion.day33;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heng Yu
 * @date 6/10/20 4:44 PM
 */

/**
 * leetcode 449: Serialize and deserialize BST
 */
public class Codec {
    public static void main(String[] args) {
        Codec solution = new Codec();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        String s = solution.serialize(root);
        System.out.println(s);
        TreeNode r = solution.deserialize(s);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();

        TreeNode dummy = new TreeNode(0);

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            if (poll == dummy) {
                sb.append("null");
            } else {
                sb.append(poll.val);

                if (poll.left == null) {
                    q.offer(dummy);
                } else {
                    q.offer(poll.left);
                }

                if (poll.right == null) {
                    q.offer(dummy);
                } else {
                    q.offer(poll.right);
                }
            }
            sb.append(',');
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] split = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(split[0]));

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        int i = 1;

        while (!q.isEmpty()) {
            if (i == split.length) break;

            TreeNode poll = q.poll();
            if (!"null".equals(split[i])) {
                poll.left = new TreeNode(Integer.parseInt(split[i]));
                q.offer(poll.left);
            }

            i++;

            if (!"null".equals(split[i])) {
                poll.right = new TreeNode(Integer.parseInt(split[i]));
                q.offer(poll.right);
            }

            i++;
        }

        return root;
    }
}
