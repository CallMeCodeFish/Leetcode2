package newquestion.day9;

/**
 * @author Heng Yu
 * @date 5/6/20 6:49 PM
 */

import java.util.Arrays;

/**
 * leetcode 953: Verifying an alien dictionary
 */
public class VerifyAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] codePoint = new int[26];
        Arrays.fill(codePoint, -1);
        char[] alphabet = order.toCharArray();
        for (int i = 0; i < alphabet.length; ++i) {
            codePoint[alphabet[i] - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; ++i) {
            if (compare(words[i], words[i + 1], codePoint) > 0) return false;
        }

        return true;
    }

    private int compare(String w1, String w2, int[] codePoint) {
        char[] chs1 = w1.toCharArray();
        char[] chs2 = w2.toCharArray();
        int i = 0, j = 0;

        while (i < chs1.length && j < chs2.length) {
            int cp1 = codePoint[chs1[i] - 'a'];
            int cp2 = codePoint[chs2[j] - 'a'];
            if (cp1 != cp2) return cp1 - cp2;
            ++i;
            ++j;
        }

        return chs1.length - chs2.length;
    }
}
