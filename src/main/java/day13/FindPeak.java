package day13;

/**
 * @author Heng Yu
 * @date 3/10/20 7:06 PM
 */

/**
 * leetcode 162: Find Peak Element
 */

public class FindPeak {
    public static void main(String[] args) {
        FindPeak solution = new FindPeak();
        int[] nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        int result = solution.findPeakElement(nums);
        System.out.println(result);
    }

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((mid == 0 || nums[mid - 1] < nums[mid]) && (mid == nums.length - 1 || nums[mid + 1] < nums[mid])) {
                return mid;
            } else if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}
