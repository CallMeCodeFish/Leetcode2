package newquestion.day39;

/**
 * @author Heng Yu
 * @date 6/20/20 5:21 PM
 */

/**
 * leetcode 977: Square of a sorted array
 */
public class SquareOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int i = 0, j = len - 1, k = len - 1;

        while (i <= j) {
            int s1 = nums[i] * nums[i];
            int s2 = nums[j] * nums[j];

            if (s1 > s2) {
                res[k--] = s1;
                i++;
            } else {
                res[k--] = s2;
                j--;
            }
        }


        return res;
    }
}
