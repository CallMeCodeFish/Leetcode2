package newquestion.day68;

/**
 * leetcode 713: Subarray product less than k
 * solution: sliding window
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums.length == 0) return 0;

        int res = 0;

        int i = 0, j = 0;
        int prod = 1;
        while (j < nums.length) {
            prod *= nums[j];
            if (prod < k) {
                res += j - i + 1;
            } else {
                while (i <= j && prod >= k) {
                    prod /= nums[i];
                    i++;
                }
                if (j - i + 1 > 0) res += j - i + 1;
            }
            j++;
        }

        return res;
    }
}
