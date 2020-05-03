package contest.May2;

/**
 * @author Heng Yu
 * @date 5/2/20 10:40 PM
 */


public class KLengthApart {
    public boolean kLengthApart(int[] nums, int k) {
        //edge case
        if (k == 0) return true;

        int index = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                if (index >= 0) {
                    int dif = i - index - 1;
                    if (dif < k) return false;
                }
                index = i;
            }
        }

        return true;
    }
}
