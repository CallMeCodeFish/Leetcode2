package day33;

/**
 * @author Heng Yu
 * @date 4/9/20 6:55 PM
 */

/**
 * leetcode 387: First Unique Character in a String
 */

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        //edge case
        if (s == null || s.isEmpty()) return -1;

        int[] memo = new int[26];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            ++memo[c - 'a'];
        }
        int res = -1;
        for (int i = 0; i < chs.length; ++i) {
            char c = chs[i];
            if (memo[c - 'a'] == 1) {
                res = i;
                break;
            }
        }
        return res;
    }
}
