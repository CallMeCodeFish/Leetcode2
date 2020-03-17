package day19;

/**
 * @author Heng Yu
 * @date 3/16/20 9:39 PM
 */

/**
 * reference: https://www.jianshu.com/p/f0dd604afccb
 * leetcode 255: Verify Preorder Sequence in Binary Search Tree
 */

public class VerifyPreorder {
    public static void main(String[] args) {
        VerifyPreorder solution = new VerifyPreorder();
        int[] nums = new int[]{5, 2, 6, 1, 3};
        boolean result = solution.verifyPreorder(nums);
        System.out.println(result);
    }

    public boolean verifyPreorder(int[] preorder) {
        return helper(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE, new int[1]);
    }

    private boolean helper(int[] nums, int min, int max, int[] index) {
        int i = index[0];
        if (i == nums.length) return true;
        int value = nums[i];
        if (max < value) return true;
        if (value < min) return false;
        ++index[0];
        return helper(nums, min, value - 1, index) && helper(nums, value + 1, max, index);
    }
}
