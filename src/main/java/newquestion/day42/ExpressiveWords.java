package newquestion.day42;

/**
 * @author Heng Yu
 * @date 6/23/20 7:29 PM
 */

/**
 * leetcode 809: Expressive words
 */
public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        char[] t = S.toCharArray();
        int len = t.length;

        int res = 0;

        for (String word : words) {
            if (word.length() <= t.length && isExtensible(t, word.toCharArray())) res++;
        }

        return res;
    }

    private boolean isExtensible(char[] t, char[] s) {
        int i = 0, j = 0;
        int startIndex = 0;

        while (i < t.length) {
            if (j == s.length) {
                int k = i;
                while (k < t.length) {
                    if (t[i - 1] != t[k]) return false;
                    k++;
                }

                if (k - startIndex < 3) return false;
                i = k;
            } else {
                if (i == 0 || t[i - 1] != t[i]) startIndex = i;

                if (t[i] == s[j]) {
                    i++;
                    j++;
                } else {
                    if (i == startIndex) return false;
                    int k = i + 1;
                    while (k < t.length && t[k] == t[i]) k++;
                    if (k - startIndex < 3) return false;
                    i = k;
                }
            }
        }

        return j == s.length;
    }
}
