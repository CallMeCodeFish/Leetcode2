package contest.mar14;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Heng Yu
 * @date 3/14/20 11:08 PM
 */

/**
 * leetcode 1383: Maximum Performance of a Team
 */

public class MaximumPerformance {
    public static void main(String[] args) {
        MaximumPerformance solution = new MaximumPerformance();
        int[] speed = new int[]{2, 10, 3, 1, 5, 8};
        int[] efficiency = new int[]{5, 4, 3, 9, 7, 2};
        int result = solution.maxPerformance(6, speed, efficiency, 4);
        System.out.println(result);
    }



    private class Pair {
        int speed;
        int efficiency;

        public Pair(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long res = 0;
        long mod = (long) Math.pow(10, 9) + 7;
        Pair[] engineers = new Pair[n];
        for (int i = 0; i < n; ++i) {
            engineers[i] = new Pair(speed[i], efficiency[i]);
        }
        Arrays.sort(engineers, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.efficiency - o1.efficiency;
            }
        });
        PriorityQueue<Pair> heap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.speed - o2.speed;
            }
        });
        int i = 0;
        int j = 0;
        long sum = 0;
        while (j < n) {
            if (heap.size() == k) {
                Pair poll = heap.poll();
                sum -= poll.speed;
            }
            heap.offer(engineers[j]);
            sum += engineers[j].speed;
            long cur = sum * engineers[j].efficiency % mod;
            res = Math.max(res, cur);
            ++j;
        }
        return (int) res;
    }
}
