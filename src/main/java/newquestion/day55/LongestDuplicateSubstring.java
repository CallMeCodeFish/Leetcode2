package newquestion.day55;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heng Yu
 * @date 7/17/20 7:40 PM
 */

/**
 * leetcode 1044: Longest duplicate substring (hard)
 * solution: binary search + rabin-karp
 * ref: https://www.bilibili.com/video/BV1Kv411B7a3?from=search&seid=8777189561111407486
 */
public class LongestDuplicateSubstring {
    public String longestDupSubstring(String S) {
        int min = 1, max = S.length();
        final long MOD = (long) Math.pow(2, 32);
        char[] chs = S.toCharArray();

        int len = 0;
        int left = 0;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int start = search(chs, mid, MOD);
            if (start != -1) {
                len = mid;
                left = start;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return len == 0? "" : S.substring(left, left + len);
    }

    private int search(char[] chs, int len, long MOD) {
        int a = 26;
        Set<Long> seen = new HashSet<>();
        long h = 0;
        long weight = 1;
        for (int i = 0; i < len; i++) {
            h = (h * 26 + (chs[i] - 'a')) % MOD;
            weight = weight * a % MOD;
        }

        seen.add(h);

        for (int i = 1; i < chs.length; i++) {
            if (chs.length - i < len) break;
            h = (h * a - (chs[i - 1] - 'a') * weight % MOD + MOD) % MOD;
            h = (h + (chs[i + len - 1] - 'a')) % MOD;
            if (seen.contains(h)) return i;
            seen.add(h);
        }

        return -1;
    }
}
