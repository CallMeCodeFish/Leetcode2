package newquestion.day57;

/**
 * @author Heng Yu
 * @date 7/19/20 6:27 PM
 */

/**
 * leetcode 769: Max chunks to make sorted
 * solution: same as #1375 Bulb switcher III
 */
public class MaxChunks {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;

        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) res++;
        }

        return res;
    }
}
