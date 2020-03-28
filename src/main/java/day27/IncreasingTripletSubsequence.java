package day27;

/**
 * @author Heng Yu
 * @date 3/27/20 6:54 PM
 */

/**
 * leetcode 334: Increasing Triplet Subsequence
 */

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();
        int[] nums = {1, 1, -2, 6};
        boolean result = solution.increasingTriplet(nums);
        System.out.println(result);
    }

    public boolean increasingTriplet(int[] nums) {
        //edge case
        if (nums == null || nums.length < 3) return false;

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int len = 0;
        for (int num : nums) {
            if (len == 0) {
                firstMin = num;
                ++len;
            } else if (len == 1) {
                if (num < firstMin) {
                    firstMin = num;
                } else if (firstMin < num) {
                    secondMin = num;
                    ++len;
                }
            } else {
                if (secondMin < num) {
                    return true;
                } else if (num < firstMin) {
                    firstMin = num;
                } else if (firstMin < num) {
                    secondMin = num;
                }
            }
        }
        return false;
    }
}
