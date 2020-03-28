package day27;

/**
 * @author Heng Yu
 * @date 3/27/20 12:34 PM
 */

/**
 * leetcode 331: Verify Preorder Serialization of a Binary Tree
 */

public class VerifyPreorder {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int[] cur = {0};
        return helper(nodes, cur) && cur[0] == nodes.length - 1;
    }

    private boolean helper(String[] nodes, int[] cur) {
        //edge case
        if (cur[0] == nodes.length) return false;
        if ("#".equals(nodes[cur[0]])) return true;

        ++cur[0];
        boolean left = helper(nodes, cur);
        if (!left) return false;
        ++cur[0];
        boolean right = helper(nodes, cur);
        return right;
    }
}
