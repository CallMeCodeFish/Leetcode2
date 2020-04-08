package day31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Heng Yu
 * @date 4/7/20 8:22 PM
 */

/**
 * leetcode 368: Largest Divisible Subset
 */

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        LargestDivisibleSubset solution = new LargestDivisibleSubset();
        int[] nums = {4,8,10,240};
        List<Integer> result = solution.largestDivisibleSubset(nums);
        System.out.println(result);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int[] preIndex = new int[len];
        preIndex[0] = -1;
        int max = 1;
        int last = 0;
        for (int i = 1; i < len; ++i) {
            dp[i] = 1;
            preIndex[i] = -1;
            int num1 = nums[i];
            for (int j = i - 1; j >= 0; --j) {
                int num2 = nums[j];
                if (num1 % num2 == 0) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        preIndex[i] = j;
                        if (max < dp[i]) {
                            max = dp[i];
                            last = i;
                        }
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (last >= 0) {
            res.add(nums[last]);
            last = preIndex[last];
        }
        Collections.reverse(res);
        return res;
    }
}
