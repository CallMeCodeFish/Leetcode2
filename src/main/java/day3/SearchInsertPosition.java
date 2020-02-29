package day3;

/**
 * @author Heng Yu
 * @date 2/29/20 12:20 AM
 */

/**
 * leetcode 35: Search Insert Position
 */

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();
        int[] nums = new int[]{1, 3, 5, 6};
        int result = solution.searchInsert(nums, 7);
        System.out.println(result);
    }

    public int searchInsert(int[] nums, int target) {
        //edge case
        if (nums == null || nums.length == 0)   return 0;

        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
