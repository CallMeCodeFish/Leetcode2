package day16;

/**
 * @author Heng Yu
 * @date 3/13/20 11:31 PM
 */

/**
 * leetcode 213: House Robber II
 */

public class HouseRobberII {
    public static void main(String[] args) {
        HouseRobberII solution = new HouseRobberII();
        int[] nums = new int[]{1};
        int result = solution.rob(nums);
        System.out.println(result);
    }

    public int rob(int[] nums) {
        //edge case
        if (nums == null || nums.length == 0) return 0;

        int gain1 = 0;
        int gain2 = 0;
        int gain3 = 0;
        int gain4 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                int copyGain1 = gain1;
                int copyGain2 = gain2;
                gain1 = copyGain2 + nums[i];
                gain2 = Math.max(copyGain1, copyGain2);
            } else if (i == nums.length - 1) {
                int copyGain3 = gain3;
                int copyGain4 = gain4;
                gain3 = copyGain4 + nums[i];
                gain4 = Math.max(copyGain3, copyGain4);
            } else {
                int copyGain1 = gain1;
                int copyGain2 = gain2;
                int copyGain3 = gain3;
                int copyGain4 = gain4;
                gain1 = copyGain2 + nums[i];
                gain2 = Math.max(copyGain1, copyGain2);
                gain3 = copyGain4 + nums[i];
                gain4 = Math.max(copyGain3, copyGain4);
            }
        }
        return Math.max(Math.max(gain1, gain2), Math.max(gain3, gain4));
    }
}
