package day23;

/**
 * @author Heng Yu
 * @date 3/20/20 5:18 PM
 */

/**
 * leetcode 303: Range Sum Query - Immutable
 */

public class RangeSumQuery {
    private int[] sums;

    public RangeSumQuery(int[] nums) {
        int len = nums.length;
        this.sums = new int[len];
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            sum += nums[i];
            this.sums[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}
