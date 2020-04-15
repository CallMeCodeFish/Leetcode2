package day33;

/**
 * @author Heng Yu
 * @date 4/9/20 4:21 PM
 */

/**
 * leetcode 383: Ransom Note
 */

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] t = magazine.toCharArray();
        char[] p = ransomNote.toCharArray();
        int[] counts = new int[26];
        for (char c : t) {
            ++counts[c - 'a'];
        }
        for (char c : p) {
            if (--counts[c - 'a'] < 0) return false;
        }
        return true;
    }
}
