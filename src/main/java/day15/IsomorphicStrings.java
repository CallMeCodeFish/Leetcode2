package day15;

/**
 * @author Heng Yu
 * @date 3/12/20 11:32 PM
 */

import java.util.Arrays;

/**
 * leetcode 205: Isomorphic Strings
 */

public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStrings solution = new IsomorphicStrings();
        String s = "paper";
        String t = "title";
        boolean result = solution.isIsomorphic(s, t);
        System.out.println(result);
    }

    public boolean isIsomorphic(String s, String t) {
        //edge case
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        char[] chsS = s.toCharArray();
        char[] chsT = t.toCharArray();
        int len = s.length();
        int[] alphabet = new int[128];
        boolean[] used = new boolean[128];
        Arrays.fill(alphabet, -1);
        for (int i = 0; i < len; ++i) {
            int key = chsS[i];
            int value = chsT[i];
            if (alphabet[key] == -1) {
                if (used[value]) return false;
                used[value] = true;
                alphabet[key] = value;
            } else {
                if (value != alphabet[key]) return false;
            }
        }
        return true;
    }
}
