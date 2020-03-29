package day28;

/**
 * @author Heng Yu
 * @date 3/28/20 7:34 PM
 */

/**
 * leetcode 345: Reverse Vowels of a String
 */

public class ReverseVowels {
    public String reverseVowels(String s) {
        //edge case
        if (s == null || s.isEmpty()) return "";

        char[] chs = s.toCharArray();
        int l = 0;
        int r = chs.length - 1;
        while (l <= r) {
            if (!isVowel(chs[l])) {
                ++l;
            } else if (!isVowel(chs[r])) {
                --r;
            } else {
                char temp = chs[l];
                chs[l] = chs[r];
                chs[r] = temp;
                ++l;
                --r;
            }
        }
        return String.valueOf(chs);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }
}
