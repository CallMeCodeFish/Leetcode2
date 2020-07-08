package newquestion.day50;

/**
 * @author Heng Yu
 * @date 7/7/20 5:04 PM
 */

/**
 * leetcode 1071 Greatest common divisor of strings
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        char[] large = null;
        char[] small = null;
        int min = 0, max = 0;

        if (len1 <= len2) {
            small = str1.toCharArray();
            large = str2.toCharArray();
            min = len1;
            max = len2;
        } else {
            small = str2.toCharArray();
            large = str1.toCharArray();
            min = len2;
            max = len1;
        }

        int i = 0, j = 0;
        while (i < max) {
            if (large[i] != small[j]) return "";
            i++;
            if (++j == min) j = 0;
        }

        int len = small.length - j;
        if (j % len == 0) {
            return String.valueOf(small, j, len);
        } else {
            return gcdOfStrings(String.valueOf(small, 0, j), String.valueOf(small, j, len));
        }
    }
}
