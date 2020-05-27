package hard;

/**
 * @author Heng Yu
 * @date 5/27/20 5:18 PM
 */

/**
 * leetcode 32: Longest valid parentheses
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        LongestValidParentheses solution = new LongestValidParentheses();
        int result = solution.longestValidParentheses("()(()");
        System.out.println(result);
    }

    public int longestValidParentheses(String s) {
        char[] chs = s.toCharArray();
        int count = 0;

        int i = 0, j = 0;

        int res = 0;

        while (j < chs.length) {
            if (chs[j] == '(') {
                ++count;
            } else {
                if (count == 0) {
                    res = Math.max(res, checkFromRight(chs, i, j));
                    i = j + 1;
                } else {
                    --count;
                }
            }
            ++j;
        }

        res = Math.max(res, checkFromRight(chs, i, j));

        return res;
    }

    private int checkFromRight(char[] chs, int l, int r) {
        if (r - l == 0) return 0;

        int count = 0;
        int res = 0;

        int i = r - 1, j = r - 1;
        while (i >= l) {
            if (chs[i] == ')') {
                ++count;
            } else {
                if (count == 0) {
                    res = Math.max(res, j - i);
                    j = i - 1;
                } else {
                    --count;
                }
            }
            --i;
        }

        res = Math.max(res, j - i);

        return res;
    }
}
