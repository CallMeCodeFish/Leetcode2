package day12;

/**
 * @author Heng Yu
 * @date 3/9/20 4:35 PM
 */

/**
 * leetcode 153: Find Minimum in Rotated Sorted Array
 */

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[l] < nums[mid]) {
                if (nums[r] < nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else if (nums[mid] < nums[l]) {
                r = mid;
            } else {
                if (nums[r] < nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return nums[l];
    }
}
