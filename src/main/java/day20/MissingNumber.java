package day20;

/**
 * @author Heng Yu
 * @date 3/17/20 10:28 PM
 */

/**
 * leetcode 268: Missing Number
 */

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber solution = new MissingNumber();
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        int result = solution.missingNumber(nums);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = n * (n + 1) / 2;
        for (int num : nums) {
            res -= num;
        }
        return res;
    }
}
