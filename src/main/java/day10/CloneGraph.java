package day10;

/**
 * @author Heng Yu
 * @date 3/6/20 11:27 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 133: Clone Graph
 */

public class CloneGraph {
    public static void main(String[] args) {
        CloneGraph solution = new CloneGraph();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        solution.cloneGraph(n1);
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        //edge case
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        helper(node, map);
        return map.get(node);
    }

    private void helper(Node node, Map<Node, Node> map) {
        Node res = new Node(node.val);
        map.put(node, res);
        List<Node> neighbors = node.neighbors;
        for (Node neighbor : neighbors) {
            if (!map.containsKey(neighbor)) {
                helper(neighbor, map);
            }
            res.neighbors.add(map.get(neighbor));
        }
    }
}
