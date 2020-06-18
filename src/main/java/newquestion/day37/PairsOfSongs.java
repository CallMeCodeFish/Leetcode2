package newquestion.day37;

/**
 * @author Heng Yu
 * @date 6/17/20 3:19 PM
 */

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1010: Pairs of songs with total durations divisible by 60
 */
public class PairsOfSongs {
    public int numPairsDivisibleBy60(int[] time) {
        final int MODULO = 60;
        int[] remains = new int[MODULO];

        int res = 0;

        for (int t : time) {
            int remain = t % MODULO;
            int complement = remain == 0 ? 0 : MODULO - remain;
            res += remains[complement];
            remains[remain]++;
        }

        return res;
    }

    public int numPairsDivisibleBy60_1(int[] time) {
        final int MODULO = 60;
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;

        for (int t : time) {
            int remain = t % MODULO;
            int complement = remain == 0? 0 : MODULO - remain;
            if (map.containsKey(complement)) {
                res += map.get(complement);
            }
            map.put(remain, map.getOrDefault(remain, 0) + 1);
        }

        return res;
    }
}
