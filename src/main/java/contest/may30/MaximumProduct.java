package contest.may30;

/**
 * @author Heng Yu
 * @date 5/30/20 10:31 PM
 */


public class MaximumProduct {
    public int maxProduct(int[] nums) {
        int firstMax = 0;
        int secondMax = 0;

        for (int num : nums) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        return (firstMax - 1) * (secondMax - 1);
    }
}
