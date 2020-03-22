package contest.mar21;

import java.util.*;

/**
 * @author Heng Yu
 * @date 3/21/20 10:30 PM
 */

/**
 * leetcode 1389: Create Target Array in the Given Order
 */

public class CreateTargetArray {
    public static void main(String[] args) {
        CreateTargetArray solution = new CreateTargetArray();
        int[] nums = new int[]{4, 2, 4, 3, 2};
        int[] index = new int[]{0, 0, 1, 3, 1};
        int[] result = solution.createTargetArray(nums, index);
        System.out.println(Arrays.toString(result));
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            int idx = index[i];
            int num = nums[i];
            list.add(idx, num);
        }
        int[] res = new int[len];
        for (int i = 0; i < len; ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}
