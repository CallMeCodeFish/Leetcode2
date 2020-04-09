package day32;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Heng Yu
 * @date 4/8/20 3:56 PM
 */

/**
 * leetcode 373: Find K Pairs with Smallest Sums
 */

public class FindKPairsWithSmallestSums {
    private static class Pair {
        List<Integer> pair;
        int sum;
        int index;

        public Pair(int n1, int n2, int index) {
            this.pair = new ArrayList<>();
            this.pair.add(n1);
            this.pair.add(n2);
            this.sum = n1 + n2;
            this.index = index;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //edge case
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return new ArrayList<>();

        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.sum - o2.sum;
            }
        });

        int m = nums1.length;
        int n = nums2.length;
        int count = 0;
        for (int j = 0; j < n; ++j) {
            if (count == k) break;
            heap.offer(new Pair(nums1[0], nums2[j], 0));
            ++count;
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            if (k == 0) break;
            Pair poll = heap.poll();
            res.add(poll.pair);
            int index = poll.index;
            if (++index < m) {
                heap.offer(new Pair(nums1[index], poll.pair.get(1), index));
            }
            --k;
        }
        return res;
    }
}
