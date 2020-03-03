package hard;

/**
 * @author Heng Yu
 * @date 3/2/20 7:10 PM
 */

/**
 * leetcode 10: Regular Expression Matching
 */

public class RegularExpressionMatching {
    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        String s = "ab";
        String p = ".*";
        boolean result = solution.isMatch(s, p);
        System.out.println(result);
    }

    public boolean isMatch(String s, String p) {
        char[] charS = s.toCharArray();
        char[] charP = p.toCharArray();
        int[][] memo = new int[s.length()][p.length()];
        return helper(charS, 0, charP, 0, memo);
    }

    private boolean helper(char[] s, int i, char[] p, int j, int[][] memo) {
        //edge case
        if (s.length <= i) {
            while (j < p.length) {
                if (j + 1 == p.length || p[j + 1] != '*') {
                    return false;
                }
                j += 2;
            }
            return true;
        } else {
            if (p.length <= j) {
                return false;
            }
        }

        if (memo[i][j] == 1) {
            return true;
        } else if (memo[i][j] == 2) {
            return false;
        }

        char text = s[i];
        char pat = p[j];
        boolean result = false;
        if (j + 1 < p.length && p[j + 1] == '*') {
            if (pat == '.' || pat == text) {
                result = helper(s, i + 1, p, j, memo) || helper(s, i, p, j + 2, memo) || helper(s, i + 1, p, j + 2, memo);
            } else {
                result = helper(s, i, p, j + 2, memo);
            }
        } else {
            if (pat == '.' || pat == text) {
                result = helper(s, i + 1, p, j + 1, memo);
            } else {
                result = false;
            }
        }
        if (result) {
            memo[i][j] = 1;
        } else {
            memo[i][j] = 2;
        }
        return result;
    }
}
