package day19;

import java.util.*;

/**
 * @author Heng Yu
 * @date 3/16/20 4:31 PM
 */

/**
 * leetcode 247: Strobogrammatic Number II
 */

public class StrobogrammaticNumberII {
    public static void main(String[] args) {
        StrobogrammaticNumberII solution = new StrobogrammaticNumberII();
        List<String> result = solution.findStrobogrammatic(3);
        System.out.println(result);
    }

    public List<String> findStrobogrammatic(int n) {
        //edge case
        if (n <= 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        char[] cur = new char[n];
        helper(0, n - 1, map, res, cur);
        return res;
    }

    private void helper(int l, int r, Map<Character, Character> map, List<String> res, char[] cur) {
        //edge case
        if (r < l) {
            res.add(String.valueOf(cur));
            return;
        }
        Set<Character> nums = map.keySet();
        if (l == r) {
            for (char num : nums) {
                if (num == '6' || num == '9') continue;
                cur[l] = num;
                res.add(String.valueOf(cur));
            }
            return;
        }
        for (char num : nums) {
            if (l == 0 && num == '0') continue;
            cur[l] = num;
            cur[r] = map.get(num);
            helper(l + 1, r - 1, map, res, cur);
        }
    }
}
