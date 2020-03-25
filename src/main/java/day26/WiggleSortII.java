package day26;

/**
 * @author Heng Yu
 * @date 3/24/20 8:30 PM
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leetcode 324: Wiggle Sort II
 */

public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            heap.offer(num);
        }
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = heap.poll();
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = heap.poll();
        }
    }

    /**
     * 3 ms solution
     * @param nums
     */
    public void wiggleSort2(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int j = copy.length - 1;
        for (int i = 1; i < nums.length; i += 2) {
            nums[i] = copy[j--];
        }
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = copy[j--];
        }
    }
}
