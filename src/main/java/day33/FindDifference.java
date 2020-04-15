package day33;

/**
 * @author Heng Yu
 * @date 4/9/20 7:13 PM
 */

/**
 * leetcode 389: Find the Difference
 */

public class FindDifference {
    public char findTheDifference(String s, String t) {
        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();
        int n = 0;
        for (char c : chs1) {
            n ^= c;
        }
        for (char c : chs2) {
            n ^= c;
        }
        return (char) n;
    }
}
