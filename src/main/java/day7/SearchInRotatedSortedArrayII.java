package day7;

/**
 * @author Heng Yu
 * @date 3/3/20 6:43 PM
 */

/**
 * leetcode 81: Search in Rotated Sorted Array II
 */

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        SearchInRotatedSortedArrayII solution = new SearchInRotatedSortedArrayII();
        int[] nums = new int[]{1, 1, 3, 1};
        boolean result = solution.search(nums, 3);
        System.out.println(result);
    }

    public boolean search(int[] nums, int target) {
        //edge case
        if (nums == null || nums.length == 0) return false;

        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] < nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[mid] < nums[l]) {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[mid] < nums[r]) {
                    if (nums[mid] < target && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else if (nums[r] < nums[mid]) {
                    if (nums[l] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    --r;
                    while (mid <= r) {
                        if (nums[r] != nums[r + 1]) {
                            break;
                        }
                        --r;
                    }
                }
            }
        }
        return false;
    }
}
