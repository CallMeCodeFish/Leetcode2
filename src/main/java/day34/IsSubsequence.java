package day34;

/**
 * @author Heng Yu
 * @date 4/21/20 9:34 PM
 */

/**
 * leetcode 392: Is Subsequence
 */

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        char[] chsS = s.toCharArray();
        char[] chsT = t.toCharArray();
        int i = 0;
        char target = chsS[i];
        for (char c : chsT) {
            if (c == target) {
                if (++i == chsS.length) return true;
                target = chsS[i];
            }
        }
        return false;
    }
}
