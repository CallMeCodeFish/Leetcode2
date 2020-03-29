package day28;

/**
 * @author Heng Yu
 * @date 3/28/20 8:00 PM
 */

import java.util.*;

/**
 * leetcode 347: Top K Frequent Element
 */

public class TopKFrequentElement {
    private class Pair {
        int value;
        int count;

        public Pair(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        //edge case
        if (k <= 0) return new ArrayList<>();

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 0);
            }
            counts.replace(num, counts.get(num) + 1);
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.count - o1.count;
            }
        });
        for (int key : counts.keySet()) {
            heap.offer(new Pair(key, counts.get(key)));
        }
        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(heap.poll().value);
            --k;
        }
        return res;
    }
}
