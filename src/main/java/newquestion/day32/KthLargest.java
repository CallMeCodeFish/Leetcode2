package newquestion.day32;

/**
 * @author Heng Yu
 * @date 6/9/20 5:32 PM
 */

import java.util.PriorityQueue;

/**
 * leetcode 703: Kth largest element in a stream
 */
public class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int size;


    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        size = k;

        for (int num : nums) {
            minHeap.offer(num);
        }

        int i = nums.length - k;
        while (i-- > 0) minHeap.poll();
    }

    public int add(int val) {
        if (minHeap.size() < size) {
            minHeap.offer(val);
        } else {
            if (val > minHeap.peek()) {
                minHeap.offer(val);
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
