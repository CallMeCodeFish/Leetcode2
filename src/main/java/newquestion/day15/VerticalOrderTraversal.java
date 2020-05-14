package newquestion.day15;

import helper.TreeNode;

import java.util.*;

/**
 * @author Heng Yu
 * @date 5/13/20 4:32 PM
 */

/**
 * leetcode 987: Vertical order traversal of a binary tree
 */
public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(root.val);

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();

        nodes.offer(root);
        levels.offer(0);

        while (!nodes.isEmpty()) {
            int size = nodes.size();
            Map<Integer, List<Integer>> memo = new HashMap<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = nodes.poll();
                int level = levels.poll();
                if (node.left != null) {
                    nodes.offer(node.left);
                    levels.offer(level - 1);
                    List<Integer> list = memo.getOrDefault(level - 1, new ArrayList<>());
                    list.add(node.left.val);
                    memo.put(level - 1, list);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                    levels.add(level + 1);
                    List<Integer> list = memo.getOrDefault(level + 1, new ArrayList<>());
                    list.add(node.right.val);
                    memo.put(level + 1, list);
                }
            }
            for (int k : memo.keySet()) {
                List<Integer> list = map.getOrDefault(k, new ArrayList<>());
                List<Integer> v = memo.get(k);
                v.sort(Integer::compareTo);
                list.addAll(v);
                map.put(k, list);
            }
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : map.keySet()) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = min; i <= max; ++i) {
            res.add(map.get(i));
        }

        return res;
    }
}
