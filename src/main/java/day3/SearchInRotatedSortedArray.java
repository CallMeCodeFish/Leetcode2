package day3;

/**
 * @author Heng Yu
 * @date 2/28/20 11:21 PM
 */

/**
 * leetcode 33: Search in Rotated Sorted Array
 */

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        int[] nums = new int[]{5, 1, 3};
        int result = solution.search(nums, 5);
        System.out.println(result);
    }

    public int search(int[] nums, int target) {
        //edge case
        if (nums == null || nums.length == 0) return -1;

        int res = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                res = mid;
                break;
            } else if (nums[l] <= target && target < nums[mid] || nums[l] > nums[mid] && (nums[l] <= target || target < nums[mid])) {
                r = mid - 1;
            } else if (nums[mid] < target || target < nums[l]) {
                l = mid + 1;
            }
        }

        return res;
    }
}
