package day15;

/**
 * @author Heng Yu
 * @date 3/12/20 9:06 PM
 */

/**
 * leetcode 198: House Robber
 */

public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber solution = new HouseRobber();
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int result = solution.rob(nums);
        System.out.println(result);
    }

    public int rob(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return 0;
        int gain1 = 0;
        int gain2 = 0;
        for (int num : nums) {
            int copyGain1 = gain1;
            int copyGain2 = gain2;
            gain1 = Math.max(copyGain1, copyGain2);
            gain2 = copyGain1 + num;
        }
        return Math.max(gain1, gain2);
    }
}
