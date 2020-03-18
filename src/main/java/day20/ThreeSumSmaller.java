package day20;

/**
 * @author Heng Yu
 * @date 3/17/20 3:53 PM
 */

import java.util.Arrays;

/**
 * leetcode 259: 3Sum Smaller
 */

public class ThreeSumSmaller {
    public static void main(String[] args) {
        ThreeSumSmaller solution = new ThreeSumSmaller();
        int[] nums = new int[]{-1, 1, -1, 0};
        int result = solution.threeSumSmaller(nums, -1);
        System.out.println(result);
    }

    public int threeSumSmaller(int[] nums, int target) {
        //edge case
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            int t = target - nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] < t) {
                    res += r - l;
                    ++l;
                } else {
                    --r;
                }
            }
        }
        return res;
    }
}
