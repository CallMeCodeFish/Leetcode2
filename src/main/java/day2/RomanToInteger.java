package day2;

/**
 * @author Heng Yu
 * @date 2/27/20 4:32 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 13: Roman to Integer
 *
 */

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger solution = new RomanToInteger();
        String s = "MCMXCIV";
        int result = solution.romanToInt(s);
        System.out.println(result);
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        char[] chs = s.toCharArray();
        List<Integer> nums = new ArrayList<>();
        for (char ch : chs) {
            int value = map.get(ch);
            if (nums.isEmpty()) {
                nums.add(value);
            } else {
                if (value < nums.get(nums.size() - 1)) {
                    nums.add(value);
                } else if (nums.get(nums.size() - 1) < value) {
                    nums.set(nums.size() - 1, value - nums.get(nums.size() - 1));
                } else {
                    nums.set(nums.size() - 1, value + nums.get(nums.size() - 1));
                }
            }
        }
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }
}
