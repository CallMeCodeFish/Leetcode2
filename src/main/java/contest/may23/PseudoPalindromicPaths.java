package contest.may23;

import helper.TreeNode;

/**
 * @author Heng Yu
 * @date 5/23/20 10:40 PM
 */


public class PseudoPalindromicPaths {
    private int res = 0;

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];

        backtracking(root, freq);

        return res;
    }

    private void backtracking(TreeNode node, int[] freq) {
        int value = node.val;
        ++freq[value];

        if (node.left == null && node.right == null) {
            int count = 0;
            for (int i = 1; i < 10; ++i) {
                if (freq[i] % 2 != 0) ++count;
            }

            if (count <= 1) ++res;
        } else if (node.left == null) {
            backtracking(node.right, freq);
        } else if (node.right == null) {
            backtracking(node.left, freq);
        } else {
            backtracking(node.left, freq);
            backtracking(node.right, freq);
        }

        --freq[value];
    }
}
