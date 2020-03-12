package day14;

/**
 * @author Heng Yu
 * @date 3/11/20 3:54 PM
 */

/**
 * leetcode 186: Reverse Words in a String II
 */

public class ReverseWordsII {
    public void reverseWords(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i <= j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            ++i;
            --j;
        }
        i = 0;
        while (i < s.length) {
            j = i + 1;
            while (j < s.length && s[j] != ' ') ++j;
            int l = i;
            int r = j - 1;
            while (l <= r) {
                char temp = s[r];
                s[r] = s[l];
                s[l] = temp;
                ++l;
                --r;
            }
            i = j + 1;
        }
    }
}
