package newquestion.day20;

/**
 * @author Heng Yu
 * @date 5/23/20 4:02 PM
 */

/**
 * leetcode 647: Palindromic substrings
 */
public class PalindromicSubstrings {
    public static void main(String[] args) {
        PalindromicSubstrings solution = new PalindromicSubstrings();
        int result = solution.countSubstrings("aaa");
        System.out.println(result);
    }

    public int countSubstrings(String s) {
        if (s.length() < 2) return s.length();

        char[] chs = s.toCharArray();
        int len = chs.length;

        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; ++i) {
            dp[i][i] = true;
            if (i < len - 1 && chs[i] == chs[i + 1]) dp[i][i + 1] = true;
        }

        for (int k = 3; k <= len; ++k) {
            for (int i = 0; i < len; ++i) {
                int j = i + k - 1;
                if (j < len && chs[i] == chs[j] && dp[i + 1][j - 1]) dp[i][j] = true;
            }
        }

        int res = 0;
        for (int i = 0; i < len; ++i) {
            for (int j = i; j < len; ++j) {
                if (dp[i][j]) ++res;
            }
        }

        return res;
    }
}
