package day18;

import java.util.Arrays;

/**
 * @author Heng Yu
 * @date 3/15/20 6:18 PM
 */


public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int[] nums = new int[]{1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        int product = 1;
        for (int i = 1; i < nums.length; ++i) {
            product *= nums[i - 1];
            res[i] = product;
        }
        product = 1;
        for (int i = nums.length - 2; i >= 0; --i) {
            product *= nums[i + 1];
            res[i] *= product;
        }
        return res;
    }
}
