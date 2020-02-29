package day3;

/**
 * @author Heng Yu
 * @date 2/28/20 11:54 PM
 */

import java.util.Arrays;

/**
 * leetcode 34: Find First and Last Position of Element in Sorted Array
 */

public class FindFirstAndLast {
    public static void main(String[] args) {
        FindFirstAndLast solution = new FindFirstAndLast();
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = solution.searchRange(nums, 6);
        System.out.println(Arrays.toString(result));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        //edge case
        if (nums == null || nums.length == 0)   return res;

        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target < nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        --l;
        if (l < 0 || nums[l] != target) return res;
        res[1] = l;
        l = 0;
        r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        res[0] = l;
        return res;
    }
}
