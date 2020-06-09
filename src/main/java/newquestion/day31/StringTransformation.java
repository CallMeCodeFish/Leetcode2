package newquestion.day31;

/**
 * @author Heng Yu
 * @date 6/8/20 7:27 PM
 */

import java.util.Arrays;

/**
 * leetcode 1153 String transforms into another string
 */
public class StringTransformation {
    public static void main(String[] args) {
        StringTransformation solution = new StringTransformation();
        boolean result = solution.canConvert("ab", "ba");
        System.out.println(result);
    }

    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;

        int len = str1.length();

        char[] chs2 = str2.toCharArray();
        boolean[] letters = new boolean[26];
        for (int i = 0; i < len; i++) {
            int c = chs2[i] - 'a';
            letters[c] = true;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (letters[i]) count++;
        }

        if (count == 26) return false;

        char[] chs1 = str1.toCharArray();

        char[] mapping = new char[26];
        Arrays.fill(mapping, ' ');

        for (int i = 0; i < len; i++) {
            int c1 = chs1[i] - 'a';
            char c2 = chs2[i];
            if (mapping[c1] == ' ') {
                mapping[c1] = c2;
            } else {
                if (mapping[c1] != c2) return false;
            }
        }

        return true;
    }
}
