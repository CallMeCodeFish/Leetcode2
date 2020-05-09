package hard;

import helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heng Yu
 * @date 5/8/20 9:45 PM
 */

/**
 * leetcode 297: Serialize and deserialize binary tree
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        TreeNode dummy = new TreeNode(-1);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == dummy) {
                sb.append("null");
            } else {
                sb.append(node.val);
                if (node.left == null) {
                    q.offer(dummy);
                } else {
                    q.offer(node.left);
                }
                if (node.right == null) {
                    q.offer(dummy);
                } else {
                    q.offer(node.right);
                }
            }
            sb.append(',');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splits = data.split(",");
        String rootValue = splits[0];
        if ("null".equals(rootValue)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(rootValue));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            if (i == splits.length) break;
            TreeNode node = q.poll();
            String leftValue = splits[i++];
            String rightValue = splits[i++];
            if (!"null".equals(leftValue)) {
                node.left = new TreeNode(Integer.parseInt(leftValue));
                q.offer(node.left);
            }
            if (!"null".equals(rightValue)) {
                node.right = new TreeNode(Integer.parseInt(rightValue));
                q.offer(node.right);
            }
        }

        return root;
    }
}
