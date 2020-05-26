package hard;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 5/25/20 7:16 PM
 */

/**
 * leetcode 315: Count of Smaller numbers after self
 */
public class CountOfSmallerNumbers {
    public static void main(String[] args) {
        CountOfSmallerNumbers solution = new CountOfSmallerNumbers();
        int[] nums = {2,0,1};
        List<Integer> result = solution.countSmaller(nums);
        System.out.println(result);
    }

    private static class Node {
        int value;
        int count;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.count = 0;
            this.left = null;
            this.right = null;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();
        if (nums.length == 0) return res;

        Node root = new Node(nums[nums.length - 1]);
        res.add(0);

        for (int i = nums.length - 2; i > -1; --i) {
            int count = addNodeToTree(root, nums[i]);
            res.add(0, count);
        }

        return res;
    }

    private int addNodeToTree(Node root, int num) {
        int res = 0;

        while (true) {
            if (root.value <= num) {
                res += (root.value < num)? root.count + 1 : root.count;
                if (root.right == null) {
                    root.right = new Node(num);
                    break;
                } else {
                    root = root.right;
                }
            } else {
                ++root.count;
                if (root.left == null) {
                    root.left = new Node(num);
                    break;
                } else {
                    root = root.left;
                }
            }
        }

        return res;
    }
}
