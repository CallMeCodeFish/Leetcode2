package newquestion.day46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 7/2/20 5:08 PM
 */

/**
 * leetcode 448: Find all numbers disappeared in an array
 */
public class FindAllDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
