package newquestion.day36;

/**
 * @author Heng Yu
 * @date 6/15/20 6:59 PM
 */

/**
 * leetcode 1060: Missing element in a sorted array
 * solution: Binary search
 */
public class MissingElement {
    public int missingElement(int[] nums, int k) {
        int len = nums.length;
        int missingCount = nums[len - 1] - nums[0] + 1 - len;
        if (k > missingCount) {
            return nums[len - 1] + k - missingCount;
        }

        int l = 0, r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            missingCount = nums[mid] - nums[0] + 1 - (mid + 1);
            if (missingCount >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        l--;
        missingCount = nums[l] - nums[0] + 1 - (l + 1);

        return nums[l] + (k - missingCount);
    }

    public int missingElement1(int[] nums, int k) {
        int count = 0;
        int i = 0;
        int target = nums[0];

        while (i < nums.length) {
            if (target == nums[i]) {
                i++;
                target++;
            } else {
                if (++count == k) break;
                target++;
            }
        }

        if (count < k) {
            target = nums[nums.length - 1] + k - count;
        }

        return target;
    }
}
