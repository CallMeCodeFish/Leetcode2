package newquestion.day16;

/**
 * @author Heng Yu
 * @date 5/15/20 2:25 PM
 */

/**
 * leetcode 680: Valid palindrome II
 */
public class ValidPalindromeII {
    public static void main(String[] args) {
        ValidPalindromeII solution = new ValidPalindromeII();
        solution.validPalindrome("abca");
    }

    public boolean validPalindrome(String s) {
        char[] chs = s.toCharArray();

        int i = 0, j = chs.length - 1;

        while (i <= j && chs[i] == chs[j]) {
            ++i;
            --j;
        }

        if (i > j) return true;

        int l = i + 1, r = j;

        while (l <= r && chs[l] == chs[r]) {
            ++l;
            --r;
        }

        if (l > r) return true;

        l = i;
        r = j - 1;

        while (l <= r) {
            if (chs[l] != chs[r]) return false;
            ++l;
            --r;
        }

        return true;
    }
}
