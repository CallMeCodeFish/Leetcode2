package contest.mar28;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heng Yu
 * @date 3/28/20 10:30 PM
 */


public class FindLuckyInteger {
    public static void main(String[] args) {
        FindLuckyInteger solution = new FindLuckyInteger();
        int[] arr = {1,2,2,3,3,3};
        int result = solution.findLucky(arr);
        System.out.println(result);
    }

    public int findLucky(int[] arr) {
        int res = -1;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : arr) {
            if (!freq.containsKey(n)) {
                freq.put(n, 0);
            }
            freq.replace(n, freq.get(n) + 1);
        }
        for (int k : freq.keySet()) {
            if (k == freq.get(k)) {
                res = Math.max(res, k);
            }
        }
        return res;
    }
}
