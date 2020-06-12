package newquestion.day34;

/**
 * @author Heng Yu
 * @date 6/11/20 5:23 PM
 */

import java.util.Arrays;

/**
 * leetcode 611: Valid triangle number
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int k = i + 2;
                for (int j = i + 1; j < nums.length; j++) {
                    int target = nums[i] + nums[j];
                    while (k < nums.length && target > nums[k]) k++;
                    res += k - 1 - j;
                }
            }
        }

        return res;
    }

    public int triangleNumber1(int[] nums) {
        Arrays.sort(nums);

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    int target = nums[i] + nums[j];
                    int l = j + 1, r = nums.length;
                    while (l < r) {
                        int m = l + (r - l) / 2;
                        if (target <= nums[m]) {
                            r = m;
                        } else {
                            l = m + 1;
                        }
                    }
                    res += l - 1 - j;
                }
            }
        }

        return res;
    }
}
