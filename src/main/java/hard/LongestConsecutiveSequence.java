package hard;

/**
 * @author Heng Yu
 * @date 5/12/20 5:42 PM
 */

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 128: Longest consecutive sequence
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        LongestConsecutiveSequence solution = new LongestConsecutiveSequence();
        int[] nums = {1,2,0,1};
        int result = solution.longestConsecutive(nums);
        System.out.println(result);
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num + 1;
                while (set.contains(cur)) ++cur;
                res = Math.max(res, cur - num);
            }
        }

        return res;
    }
}
