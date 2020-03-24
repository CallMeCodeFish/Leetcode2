package contest.mar21;

/**
 * @author Heng Yu
 * @date 3/23/20 5:18 PM
 */

/**
 * leetcode 1392: Longest Happy Prefix
 */

public class LongestHappyPrefix {
    public static void main(String[] args) {
        LongestHappyPrefix solution = new LongestHappyPrefix();
        String s = "a";
        String result = solution.longestPrefix(s);
        System.out.println(result);
    }

    public String longestPrefix(String s) {
        char[] chs = s.toCharArray();
        int[] next = buildNext(chs);
        int lastIndex = next[next.length - 1];
        while (0 <= lastIndex && chs[lastIndex] != chs[chs.length - 1]) {
            lastIndex = next[lastIndex];
        }
        return s.substring(0, lastIndex + 1);
    }

    private int[] buildNext(char[] chs) {
        int[] next = new int[chs.length];
        next[0] = -1;
        int i = -1;
        int j = 0;
        while (j < chs.length - 1) {
            if (i == -1 || chs[i] == chs[j]) {
                ++i;
                ++j;
                next[j] = i;
            } else {
                i = next[i];
            }
        }
        return next;
    }
}
