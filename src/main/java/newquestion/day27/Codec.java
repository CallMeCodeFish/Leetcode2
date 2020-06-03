package newquestion.day27;

import java.util.*;

/**
 * @author Heng Yu
 * @date 6/2/20 5:47 pm
 */

/**
 * leetcode 428: Serialize and deserialize n-ary tree
 */
public class Codec {
    public static void main(String[] args) {
        Codec solution = new Codec();
        Node root = new Node(1);
        root.children = new ArrayList<>();
        Node n3 = new Node(3);
        n3.children = new ArrayList<>();
        Node n2 = new Node(2);
        n2.children = new ArrayList<>();
        Node n4 = new Node(4);
        n4.children = new ArrayList<>();
        root.children.addAll(Arrays.asList(n3, n2, n4));
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n3.children.addAll(Arrays.asList(n5, n6));
        String result = solution.serialize(root);
        System.out.println(result);

        Node deserialize = solution.deserialize(result);
    }

    private static class Node {
        int val;
        List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }


    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) return "";

        Node sep = new Node();
        Queue<Node> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.offer(root);
        q.offer(sep);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node poll = q.poll();
                if (poll == sep) {
                    sb.append("null");
                } else {
                    sb.append(poll.val);
                    if (poll.children != null) {
                        for (Node child : poll.children) {
                            q.offer(child);
                        }
                    }
                    q.offer(sep);
                }
                sb.append(" ");
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if ("".equals(data)) return null;

        String[] split = data.split(" ");
        Node root = new Node(Integer.parseInt(split[0]));
        if (split.length == 2) return root;

        int cur = 2;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node poll = q.poll();
                poll.children = new ArrayList<>();
                while (!"null".equals(split[cur])) {
                    Node child = new Node(Integer.parseInt(split[cur]));
                    q.offer(child);
                    poll.children.add(child);
                    cur++;
                }
                cur++;
            }
        }

        return root;
    }
}
