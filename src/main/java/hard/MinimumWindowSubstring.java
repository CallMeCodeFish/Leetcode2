package hard;

/**
 * @author Heng Yu
 * @date 5/7/20 5:58 PM
 */

import java.util.*;

/**
 * leetcode 76: Minimum window substring
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String s = "a", t = "aa";
        String result = solution.minWindow(s, t);
        System.out.println(result);
    }

    public String minWindow(String s, String t) {
        char[] chs = t.toCharArray();
        int[] target = new int[128];
        int[] cur = new int[128];
        for (char ch : chs) {
            ++target[ch];
        }

        int len = 0;
        Queue<Integer> indices = new LinkedList<>();
        chs = s.toCharArray();

        int min = chs.length;
        int start = 0, end = chs.length;
        boolean canFind = false;

        int j = 0;
        while (j < chs.length) {
            char ch = chs[j];
            if (target[ch] != 0) {
                indices.offer(j);
                ++cur[ch];
                if (target[ch] == cur[ch]) {
                    len += target[ch];
                    while (len == t.length()) {
                        canFind = true;
                        int i = indices.poll();
                        if (j - i + 1 < min) {
                            min = j - i + 1;
                            start = i;
                            end = j + 1;
                        }
                        ch = chs[i];
                        --cur[ch];
                        if (cur[ch] < target[ch]) {
                            len -= target[ch];
                        }
                    }
                }
            }
            ++j;
        }

        if (!canFind) return "";

        return s.substring(start, end);
    }
}
