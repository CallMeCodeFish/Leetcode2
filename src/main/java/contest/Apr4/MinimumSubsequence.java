package contest.Apr4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Heng Yu
 * @date 4/4/20 10:30 PM
 */


public class MinimumSubsequence {
    public static void main(String[] args) {
        MinimumSubsequence solution = new MinimumSubsequence();
        int[] nums = {73,71,26,65,53,63,46,54,45,1,69,70,80,79,43,59,77,4,30,82,23,71,75,24,12,71,33,5,87,10,11,3,58,2,97,97,36,32,35,15,80,24,45,38,9,22,21,33,68,22,85,35,83,92,38,59};
        List<Integer> result = solution.minSubsequence(nums);
        System.out.println(result);
    }

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            int num = nums[i];
            res.add(num);
            sum += num;
            if (sum > totalSum - sum) break;
        }
        return res;
    }
}
