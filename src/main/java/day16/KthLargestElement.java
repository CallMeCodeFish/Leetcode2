package day16;

/**
 * @author Heng Yu
 * @date 3/13/20 11:59 PM
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 215: Kth Largest Element in an Array
 */

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * solution using priority queue
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int num : nums) {
            q.offer(num);
        }
        int res = 0;
        for (int i = 0; i < k; ++i) {
            res = q.poll();
        }
        return res;
    }
}
