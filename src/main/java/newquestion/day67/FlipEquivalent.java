package newquestion.day67;


import helper.TreeNode;

/**
 * leetcode 951: Flip equivalent binary trees
 */
public class FlipEquivalent {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null || root1.val != root2.val) return false;

        return helper(root1, root2);
    }

    private boolean helper(TreeNode n1, TreeNode n2) {
        int count1 = 0;
        if (n1.left != null) count1++;
        if (n1.right != null) count1++;

        int count2 = 0;
        if (n2.left != null) count2++;
        if (n2.right != null) count2++;

        if (count1 != count2) return false;

        if (count1 == 0) return true;

        if (count1 == 2) {
            if (n1.left.val == n2.left.val && n1.right.val == n2.right.val) {
                return helper(n1.left, n2.left) && helper(n1.right, n2.right);
            } else if (n1.left.val == n2.right.val && n1.right.val == n2.left.val) {
                return helper(n1.left, n2.right) && helper(n1.right, n2.left);
            } else {
                return false;
            }
        } else {
            if (n1.left != null) {
                if (n2.left != null) {
                    if (n1.left.val != n2.left.val) return false;
                    return helper(n1.left, n2.left);
                } else {
                    if (n1.left.val != n2.right.val) return false;
                    return helper(n1.left, n2.right);
                }
            } else {
                if (n2.left != null) {
                    if (n1.right.val != n2.left.val) return false;
                    return helper(n1.right, n2.left);
                } else {
                    if (n1.right.val != n2.right.val) return false;
                    return helper(n1.right, n2.right);
                }
            }
        }
    }
}
