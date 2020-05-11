package hard;

/**
 * @author Heng Yu
 * @date 5/11/20 4:28 PM
 */

import java.util.PriorityQueue;

/**
 * leetcode 295: Find median from data stream
 * solution: two heaps and balance these heaps.
 */
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>((a, b) -> b - a);
        this.minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        }  else {
            minHeap.offer(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int size = maxHeap.size() + minHeap.size();
        double res = 0;
        if (size % 2 == 0) {
            res = (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            res = maxHeap.peek();
        }

        return res;
    }
}
