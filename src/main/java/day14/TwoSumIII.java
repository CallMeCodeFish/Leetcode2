package day14;

/**
 * @author Heng Yu
 * @date 3/11/20 11:19 AM
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 170: Two Sum III
 */

public class TwoSumIII {
    Map<Integer, Integer> map;

    /** Initialize your data structure here. */
    public TwoSumIII() {
        map = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 0);
        }
        map.replace(number, map.get(number) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Set<Integer> keys = map.keySet();
        for (int first : keys) {
            int second = value - first;
            if (map.containsKey(second)) {
                if (first != second || first == second && 1 < map.get(second)) return true;
            }
        }
        return false;
    }
}
