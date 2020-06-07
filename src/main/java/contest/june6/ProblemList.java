package contest.june6;

/**
 * @author Heng Yu
 * @date 6/6/20 10:31 PM
 */


public class ProblemList {
    public int[] shuffle(int[] nums, int n) {
        int len = 2 * n;
        int[] res = new int[len];

        int i = 0, j = n;
        for (int k = 0; k < len; k++) {
            if (k % 2 == 0) {
                res[k] = nums[i++];
            } else {
                res[k] = nums[j++];
            }
        }

        return res;
    }
}
