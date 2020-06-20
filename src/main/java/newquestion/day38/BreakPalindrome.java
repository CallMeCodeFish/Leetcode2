package newquestion.day38;

/**
 * @author Heng Yu
 * @date 6/19/20 5:43 PM
 */

/**
 * leetcode 1328: Break a palindrome
 */
public class BreakPalindrome {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";

        char[] chs = palindrome.toCharArray();

        StringBuilder sb = new StringBuilder();

        int i = 0;
        boolean isOddLength = chs.length % 2 == 0 ? false : true;
        boolean modified = false;
        while (i < chs.length) {
            char c = chs[i];
            if (!modified) {
                if (c != 'a') {
                    if (isOddLength &&  i == chs.length / 2) {
                        sb.append(c);
                    } else {
                        sb.append('a');
                        modified = true;
                    }
                } else {
                    if (i != chs.length - 1) {
                        sb.append(c);
                    } else {
                        sb.append('b');
                    }
                }
            } else {
                sb.append(c);
            }

            i++;
        }

        return sb.toString();
    }
}
