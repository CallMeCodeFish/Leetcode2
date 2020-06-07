package contest.june6;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Heng Yu
 * @date 6/6/20 10:37 PM
 */


public class KStrongestValues {
    private static class Strong {
        double abs;
        int value;

        public Strong(double abs, int value) {
            this.abs = abs;
            this.value = value;
        }
    }

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);

        int len = arr.length;
        double m = arr[(len - 1) / 2];

        PriorityQueue<Strong> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.abs < b.abs) {
                return 1;
            } else if (a.abs > b.abs) {
                return -1;
            } else {
                return b.value - a.value;
            }
        });

        for (int i = 0; i < len; i++) {
            maxHeap.offer(new Strong(Math.abs(arr[i] - m), arr[i]));
        }

        int[] res = new int[k];

        int i = 0;
        while (k > 0) {
            res[i++] = maxHeap.poll().value;
            k--;
        }

        return res;
    }
}
