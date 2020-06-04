package newquestion.day28;

/**
 * @author Heng Yu
 * @date 6/3/20 7:09 PM
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * leetcode 480 Sliding window median
 */
public class SlidingWindowMedian {
    public static void main(String[] args) {
        SlidingWindowMedian solution = new SlidingWindowMedian();
        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        double[] result = solution.medianSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }

    public double[] medianSlidingWindow1(int[] nums, int k) {
        int len = nums.length - k + 1;
        double[] res = new double[len];

        TreeMap<Integer, Integer> map = new TreeMap<>();

        int i = 0, j = 0;
        int m = 0;
        int cur = 0;
        while (j < nums.length) {
            map.putIfAbsent(nums[j], 0);
            map.replace(nums[j], map.get(nums[j]) + 1);
            if (++cur == k) {
                res[m++] = getMedian(map, k);
                map.replace(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) map.remove(nums[i]);
                i++;
                cur--;
            }
            j++;
        }

        return res;
    }

    private double getMedian(TreeMap<Integer, Integer> map, int k) {
        double res = 0;

        if (k % 2 == 0) {
            double first = 0;
            double second = 0;
            int target = k / 2;
            int cur = 0;
            boolean found = false;
            for (Integer key : map.keySet()) {
                cur += map.get(key);
                if (cur >= target) {
                    if (cur == target) {
                        first = key;
                        found = true;
                    } else {
                        if (found) {
                            second = key;
                        } else {
                            first = second = key;
                        }
                        break;
                    }
                }
            }
            res = (first + second) / 2;
        } else {
            int target = k / 2 + 1;
            int cur = 0;
            for (Integer key : map.keySet()) {
                cur += map.get(key);
                if (cur >= target) {
                    res = key;
                    break;
                }
            }
        }

        return res;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        double[] res = new double[len];
        if (k == 1) {
            for (int i = 0; i < nums.length; i++) {
                res[i] = nums[i];
            }
            return res;
        }

        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a - b < 0) return 1;
            if (b - a < 0) return -1;
            return 0;
        });
        PriorityQueue<Double> minHeap = new PriorityQueue<>();

        int i = 0, j = 0;
        int w = 0;

        while (j < nums.length) {
            if (maxHeap.isEmpty() || nums[j] <= maxHeap.peek()) {
                maxHeap.offer((double) nums[j]);
            } else {
                minHeap.offer((double) nums[j]);
            }

            while (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }

            while (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            if (maxHeap.size() + minHeap.size() == k) {
                if (k % 2 == 0) {
                    double sum = maxHeap.peek() + minHeap.peek();
                    res[w++] = sum / 2;
                } else {
                    res[w++] = maxHeap.peek();
                }

                if (nums[i] <= maxHeap.peek()) {
                    maxHeap.remove((double) nums[i]);
                } else {
                    minHeap.remove((double) nums[i]);
                }
                while (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.offer(maxHeap.poll());
                }

                while (maxHeap.size() < minHeap.size()) {
                    maxHeap.offer(minHeap.poll());
                }
                i++;
            }
            j++;
        }

        return res;
    }
}
