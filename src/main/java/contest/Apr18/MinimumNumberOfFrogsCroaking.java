package contest.Apr18;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 4/18/20 11:30 PM
 */


public class MinimumNumberOfFrogsCroaking {
    public static void main(String[] args) {
        MinimumNumberOfFrogsCroaking solution = new MinimumNumberOfFrogsCroaking();
        int result = solution.minNumberOfFrogs("ck");
        System.out.println(result);
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        char[] chs = croakOfFrogs.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chs) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.replace(c, map.get(c) + 1);
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (char c : map.keySet()) {
            int count = map.get(c);
            if (count < min) {
                min = count;
            }
            if (count > max) {
                max = count;
            }
        }
        if (max != min) return -1;

        int res = 0, cur = 0;
        for (char c : chs) {
            if (c == 'c') {
                ++cur;
                res = Math.max(res, cur);
            } else {
                if (cur == 0) return -1;
                if (c == 'k') {
                    --cur;
                }
            }
        }
        return res;
    }
}
