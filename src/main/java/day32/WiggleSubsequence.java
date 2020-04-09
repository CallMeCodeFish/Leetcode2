package day32;

/**
 * @author Heng Yu
 * @date 4/8/20 5:59 PM
 */

/**
 * leetcode 376: Wiggle Subsequence
 */

public class WiggleSubsequence {

    public static void main(String[] args) {
        WiggleSubsequence solution = new WiggleSubsequence();
        int[] nums = {5,4,3,2,1};
        int result = solution.wiggleMaxLength(nums);
        System.out.println(result);
    }

    public int wiggleMaxLength(int[] nums) {
        //edge case
        if (nums == null) return 0;
        if (nums.length < 2) return nums.length;

        int len = nums.length;
        int[] lengths = new int[len];
        int[] signs = new int[len];
        lengths[0] = 1;
        int res = 1;
        for (int i = 1; i < len; ++i) {
            lengths[i] = 1;
            for (int j = i - 1; j >= 0; --j) {
                if (signs[j] == 0) {
                    if (nums[i] != nums[j] && lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        res = Math.max(res, lengths[i]);
                        signs[i] = (nums[j] < nums[i])? 1 : -1;
                    }
                } else if (signs[j] < 0) {
                    if (nums[i] > nums[j] && lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        res = Math.max(res, lengths[i]);
                        signs[i] = 1;
                    }
                } else {
                    if (nums[i] < nums[j] && lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        res = Math.max(res, lengths[i]);
                        signs[i] = -1;
                    }
                }
            }
        }
        return res;
    }
}
