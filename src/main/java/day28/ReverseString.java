package day28;

/**
 * @author Heng Yu
 * @date 3/28/20 7:31 PM
 */

/**
 * leetcode 344: Reverse String
 */

public class ReverseString {
    public void reverseString(char[] s) {
        //edge case
        if (s == null) return;

        int l = 0;
        int r = s.length - 1;
        while (l <= r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            ++l;
            --r;
        }
    }
}
