package contest.june13;

/**
 * @author Heng Yu
 * @date 6/15/20 5:11 PM
 */

/**
 * solution: binary search 与1011相同
 */
public class MinimumNumberOfDays {
    public static void main(String[] args) {
        MinimumNumberOfDays solution = new MinimumNumberOfDays();
        int[] nums = {1000000000,1000000000};
        int result = solution.minDays(nums, 1, 1);
        System.out.println(result);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int l = 1, h = 1000000000;

        while (l < h) {
            int mid = l + (h - l) / 2;
            if (isValid(bloomDay, m, k, mid)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }

        return isValid(bloomDay, m, k, l) ? l : -1;
    }

    private boolean isValid(int[] nums, int m, int k, int target) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            int j = i;
            int cur = 0;
            while (j < nums.length) {
                if (nums[j] > target) break;
                if (++cur == k) break;
                j++;
            }
            if (cur == k) {
                count++;
            }
                i = j + 1;
        }

        return count >= m;
    }
}
