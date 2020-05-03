package newquestion.day7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 5/2/20 7:59 PM
 */

/**
 * leetcode 442: Find all duplicates in an array
 */
public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        return res;
    }
}
