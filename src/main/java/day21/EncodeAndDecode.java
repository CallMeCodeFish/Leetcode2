package day21;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heng Yu
 * @date 3/18/20 7:33 PM
 */

/**
 * leetcode 271: Encode and Decode Strings
 */

public class EncodeAndDecode {
    public static void main(String[] args) {
        EncodeAndDecode solution = new EncodeAndDecode();
        List<String> strs = new ArrayList<>();
        strs.add("");
        String encode = solution.encode(strs);
        List<String> result = solution.decode(encode);
        System.out.println(result);
    }

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        //edge case
        if (strs == null || strs.isEmpty()) return "";

        String sep = String.valueOf((char) 257);
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
            sb.append(sep);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        //edge case
        if (s == null || s.isEmpty()) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        String sep = String.valueOf((char) 257);
        String[] splits = s.split(sep, -1);
        for (int i = 0; i < splits.length - 1; ++i) {
            res.add(splits[i]);
        }
        return res;
    }
}
