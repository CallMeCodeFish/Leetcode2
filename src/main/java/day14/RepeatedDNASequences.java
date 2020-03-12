package day14;

/**
 * @author Heng Yu
 * @date 3/11/20 4:41 PM
 */

import java.util.*;

/**
 * leetcode 187: Repeated DNA Sequences
 */

public class RepeatedDNASequences {
    public static void main(String[] args) {
        RepeatedDNASequences solution = new RepeatedDNASequences();
        List<String> result = solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(result);
    }

    public List<String> findRepeatedDnaSequences(String s) {
        //edge case
        if (s == null || s.length() <= 10) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; ++i) {
            String sub = s.substring(i, i + 10);
            if (map.containsKey(sub)) {
                if (map.get(sub) == 1) {
                    res.add(sub);
                }
                map.replace(sub, map.get(sub) + 1);
            } else {
                map.put(sub, 1);
            }
        }
        return res;
    }
}
