package contest.june13;

import java.util.*;

/**
 * @author Heng Yu
 * @date 6/13/20 10:39 PM
 */


public class LeastNumberOfUnique {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int num : arr) {
            int[] pair = map.getOrDefault(num, new int[]{num, 0});
            pair[1]++;
            map.put(num, pair);
        }

        List<int[]> list = new ArrayList<>(map.values());

        list.sort((a, b) -> a[1] - b[1]);

        int removed = 0;

        for (int[] pair : list) {
            if (pair[1] <= k) {
                k -= pair[1];
                removed++;
            } else {
                break;
            }
        }

        return map.size() - removed;
    }
}
