package newquestion.day44;

/**
 * @author Heng Yu
 * @date 6/28/20 9:03 PM
 */

/**
 * leetcode 678: Valid parenthesis string
 * solution: greedy
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int min = 0, max = 0;

        char[] chs = s.toCharArray();

        for (char c : chs) {
            min += c == '(' ? 1 : -1;
            max += c != ')' ? 1 : -1;
            if (max < 0) return false;
            min = Math.max(min, 0);
        }

        return min == 0;
    }
}
