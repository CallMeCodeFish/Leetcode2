package newquestion.day43;

/**
 * @author Heng Yu
 * @date 6/27/20 8:45 PM
 */

/**
 * leetcode 214: Shortest palindrome (hard)
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s.isEmpty()) return "";

        char[] chs = s.toCharArray();
        int len = chs.length;

        int i = len - 1;
        while (i >= 0) {
            int j = 0, k = i;
            boolean isPalindrome = true;

            while (j <= k) {
                if (chs[j] != chs[k]) {
                    isPalindrome = false;
                    break;
                }
                j++;
                k--;
            }

            if (isPalindrome) break;
            i--;
        }

        StringBuilder sb = new StringBuilder();

        int j = len - 1;
        while (i < j) {
            sb.append(chs[j]);
            j--;
        }

        sb.append(s);

        return sb.toString();
    }
}
