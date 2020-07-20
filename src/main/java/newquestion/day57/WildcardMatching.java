package newquestion.day57;

/**
 * @author Heng Yu
 * @date 7/19/20 7:03 PM
 */

/**
 * leetcode 44: Wildcard matching (hard)
 * solution: recursion + memorization
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        char[] chs1 = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c != '*' || sb.length() == 0 || sb.charAt(sb.length() - 1) != '*') sb.append(c);
        }

        char[] chs2 = sb.toString().toCharArray();

        int[][] memo = new int[chs1.length][chs2.length];

        return helper(chs1, 0, chs2, 0, memo);
    }

    private boolean helper(char[] chs1, int i, char[] chs2, int j, int[][] memo) {
        if (i == chs1.length) {
            while (j < chs2.length) {
                if (chs2[j] != '*') return false;
                j++;
            }
            return true;
        }

        if (j == chs2.length) return false;

        if (memo[i][j] > 0) return memo[i][j] == 2;

        char c1 = chs1[i];
        char c2 = chs2[j];

        boolean res = false;

        if (c2 == '?') {
            res = helper(chs1, i + 1, chs2, j + 1, memo);
        } else if (c2 == '*') {
            //accelerate
            if (j + 1 == chs2.length) {
                res = true;
            } else {
                //omit *
                if (chs2[j + 1] == '?' || chs2[j + 1] == chs1[i]) {
                    if (helper(chs1, i, chs2, j + 1, memo)) {
                        res = true;
                    }
                }

                if (i + 1 < chs1.length) {
                    if (!res) {
                        //match
                        if (chs2[j + 1] == '?' || chs2[j + 1] == chs1[i + 1]) {
                            if (helper(chs1, i + 1, chs2, j + 1, memo)) {
                                res = true;
                            }
                        }
                    }

                    if (!res) {
                        //greedy
                        res = helper(chs1, i + 1, chs2, j, memo);
                    }
                }
            }
        } else {
            if (c1 != c2) {
                res = false;
            } else {
                res = helper(chs1, i + 1, chs2, j + 1, memo);
            }
        }

        memo[i][j] = res ? 2 : 1;

        return res;
    }
}
