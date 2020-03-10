package day12;

/**
 * @author Heng Yu
 * @date 3/9/20 3:45 PM
 */

import java.util.Arrays;

/**
 * leetcode 151: Reverse Words In a String
 */

public class ReverseWordsInString {
    public static void main(String[] args) {
        ReverseWordsInString solution = new ReverseWordsInString();
        String s = "  hello world!  ";
        String result = solution.reverseWords(s);
//        System.out.println(result);
    }

    public String reverseWords(String s) {
        //edge case
        if (s == null || s.isEmpty()) return "";

        String[] splits = s.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (int i = splits.length - 1; i >= 0; --i) {
            String split = splits[i];
            if (!split.isEmpty()) {
                sb.append(split);
                sb.append(" ");
            }
        }
        if (sb.length() != 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
