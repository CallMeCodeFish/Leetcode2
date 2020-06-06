package newquestion.day30;

/**
 * @author Heng Yu
 * @date 6/5/20 3:24 PM
 */

import java.util.Arrays;

/**
 * leetcode 1283: Find the smallest divisor given a threshold
 * solution: binary search
 */
public class FindSmallestDivisor {
    public static void main(String[] args) {
        FindSmallestDivisor solution = new FindSmallestDivisor();
        int[] nums = {1,2,5,9};
        int result = solution.smallestDivisor(nums, 6);
        System.out.println(result);
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int len = nums.length;

        // sort
        Arrays.sort(nums);

        // find sum and max
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int max = nums[len - 1];

        if (threshold == sum) return 1;
        if (threshold == len) return max;


        //binary search
        int l = 1, r = max;

        while (l < r) {
            int mid = l + (r - l) / 2;
            int cur = 0;
            for (int num : nums) {
                cur += num / mid;
                if (num % mid != 0) cur++;
            }

            if (cur > threshold) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }


        return l;
    }
}
