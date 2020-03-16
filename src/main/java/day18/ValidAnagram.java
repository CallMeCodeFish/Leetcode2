package day18;

/**
 * @author Heng Yu
 * @date 3/15/20 8:49 PM
 */

/**
 * leetcode 242: Valid Anagram
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        //edge case
        if (s.length() != t.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        char[] chsS = s.toCharArray();
        char[] chsT = t.toCharArray();
        int len = chsS.length;
        for (int i = 0; i < len; ++i) {
            int idx1 = chsS[i] - 'a';
            int idx2 = chsT[i] - 'a';
            ++count1[idx1];
            ++count2[idx2];
        }
        for (int i = 0; i < 26; ++i) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }
}
