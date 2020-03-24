package day25;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/23/20 9:14 PM
 */

/**
 * leetcode 320: Generalized Abbreviation
 */

public class GeneralizedAbbreviation {
    public static void main(String[] args) {
        GeneralizedAbbreviation solution = new GeneralizedAbbreviation();
        List<String> result = solution.generateAbbreviations("word");
        System.out.println(result);
    }

    public List<String> generateAbbreviations(String word) {
        //edge case
        if (word == null) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        if (word.isEmpty()) {
            res.add("");
            return res;
        }

        char[] chs = word.toCharArray();
        backtrack(chs, 0, res, new StringBuilder());
        return res;
    }

    private void backtrack(char[] chs, int i, List<String> res, StringBuilder builder) {
        //edge case
        if (i == chs.length) {
            res.add(builder.toString());
            return;
        }

        builder.append(chs[i]);
        backtrack(chs, i + 1, res, builder);
        builder.deleteCharAt(builder.length() - 1);
        if (builder.length() != 0) {
            if (Character.isDigit(builder.charAt(builder.length() - 1))) {
                int start = builder.length() - 1;
                while (start - 1 >= 0 && Character.isDigit(builder.charAt(start - 1))) --start;
                String cache = builder.substring(start);
                builder.delete(start, builder.length());
                builder.append(Integer.parseInt(cache) + 1);
                backtrack(chs, i + 1, res, builder);
                builder.delete(start, builder.length());
                builder.append(cache);
            } else {
                builder.append(1);
                backtrack(chs, i + 1, res, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        } else {
            builder.append(1);
            backtrack(chs, i + 1, res, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
