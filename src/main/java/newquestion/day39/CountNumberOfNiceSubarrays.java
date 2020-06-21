package newquestion.day39;

/**
 * @author Heng Yu
 * @date 6/20/20 6:09 PM
 */

/**
 * leetcode 1248: Count number of nice subarrays
 */
public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int count = 0;
        int i = 0, j = 0;
        int n1 = 0, n2 = 0;

        while (j < nums.length) {
            if (count < k) {
                if (nums[j] % 2 == 1) {
                    count++;
                }
                if (count == k) n2 = 1;
                j++;
            } else {
                if (nums[j] % 2 == 1) {
                    count--;
                    n1 = 0;
                    while (i < j && nums[i] % 2 == 0) {
                        n1++;
                        i++;
                    }
                    n1++;
                    res += n1 * n2;
                    i++;
                } else {
                    n2++;
                    j++;
                }
            }
        }

        if (count == k) {
            n1 = 0;
            while (i < nums.length && nums[i] % 2 == 0) {
                n1++;
                i++;
            }
            n1++;
            res += n1 * n2;
        }

        return res;
    }
}
