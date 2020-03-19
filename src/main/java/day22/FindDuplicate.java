package day22;

/**
 * @author Heng Yu
 * @date 3/19/20 4:39 PM
 */

/**
 * leetcode 287: Find the Duplicate Number
 */

public class FindDuplicate {
    public static void main(String[] args) {
        FindDuplicate solution = new FindDuplicate();
        int[] nums = new int[]{2,5,9,6,9,3,8,9,7,1};
        int result = solution.findDuplicate(nums);
        System.out.println(result);
    }

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (fast == slow) break;
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
