package hard;

/**
 * @author Heng Yu
 * @date 5/15/20 4:54 PM
 */

import java.util.Arrays;
import java.util.TreeMap;

/**
 * leetcode 239: Sliding window maximum
 * solution: dp, time complexity: O(n)
 */
public class SlidingWindowMax {
    public static void main(String[] args) {
        SlidingWindowMax solution = new SlidingWindowMax();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] result = solution.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        //edge case
        if (k == 1) return nums;

        int len = nums.length - k + 1;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int i = 0;
        while (i < nums.length) {
            int j = Math.min(i + k - 1, nums.length - 1);
            for (int p = i; p <= j; ++p) {
                if (p == i) {
                    left[p] = nums[p];
                } else {
                    left[p] = Math.max(nums[p], left[p - 1]);
                }
            }

            for (int p = j; p >= i; --p) {
                if (p == j) {
                    right[p] = nums[p];
                } else {
                    right[p] = Math.max(nums[p], right[p + 1]);
                }
            }
            i = j + 1;
        }

        int[] res = new int[len];

        for (i = 0; i < len; ++i) {
            int j = Math.min(nums.length - 1, i + k - 1);
            res[i] = Math.max(right[i], left[j]);
        }

        return res;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        //edge case
        if (k == 1) return nums;

        int len = nums.length - k + 1;
        int[] res = new int[len];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int i = 0, j = 0, p = 0;
        int curLen = 0;
        while (j < nums.length) {
            int num = nums[j];
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
            if (++curLen == k) {
                res[p++] = map.lastKey();
                map.replace(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
                ++i;
                --curLen;
            }
            ++j;
        }

        return res;
    }
}
