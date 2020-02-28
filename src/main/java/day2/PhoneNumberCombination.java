package day2;

/**
 * @author Heng Yu
 * @date 2/27/20 7:53 PM
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 17: Letter Combinations of a Phone Number
 */

public class PhoneNumberCombination {
    public static void main(String[] args) {
        PhoneNumberCombination solution = new PhoneNumberCombination();
        List<String> result = solution.letterCombinations("23");
        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {
        //edge case
        if (digits == null || digits.isEmpty())
            return new ArrayList<>();

        Map<Character, List<Character>> map = new HashMap<>();
        int offset = 0;
        for (int i = 2; i <= 9; ++i) {
            char key = (char) ('0' + i);
            List<Character> list = new ArrayList<>();
            if (key != '7' && key != '9') {
                for (int j = 0; j < 3; ++j) {
                    char ch = (char) ('a' + offset++);
                    list.add(ch);
                }
            } else {
                for (int j = 0; j < 4; ++j) {
                    char ch = (char) ('a' + offset++);
                    list.add(ch);
                }
            }
            map.put(key, list);
        }

        List<String> res = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backtrack(digits, 0, map, builder, res);
        return res;
    }

    private void backtrack(String s, int i, Map<Character, List<Character>> map, StringBuilder builder, List<String> res) {
        //edge case
        if (i == s.length()) {
            res.add(builder.toString());
            return;
        }

        char cur = s.charAt(i);
        List<Character> chs = map.get(cur);
        for (char ch : chs) {
            builder.append(ch);
            backtrack(s, i + 1, map, builder, res);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
