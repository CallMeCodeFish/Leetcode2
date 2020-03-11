package day13;

/**
 * @author Heng Yu
 * @date 3/10/20 9:43 PM
 */

/**
 * leetcode 167: Two Sum II Input array is sorted
 */

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] res = new int[2];
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                break;
            } else if (sum < target) {
                ++l;
            } else {
                --r;
            }
        }
        return res;
    }
}
