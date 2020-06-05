package newquestion.day29;

/**
 * @author Heng Yu
 * @date 6/4/20 8:10 PM
 */

/**
 * leetcode 65: Valid number
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        char[] chs = s.trim().toCharArray();

        if (chs.length == 0) return false;

        boolean hasExponent = false;
        boolean hasFrontNum = false;
        boolean hasRearNum = false;
        boolean hasDot = false;

        for (int i = 0; i < chs.length; i++) {
            char c = chs[i];
            if (Character.isDigit(c)) {
                if (!hasExponent) {
                    if (!hasFrontNum) hasFrontNum = true;
                } else {
                    if (!hasRearNum) hasRearNum = true;
                }
            } else if (c == '+' || c == '-') {
                if (i == chs.length - 1 || i != 0 && chs[i - 1] != 'e') return false;
            } else if (c == '.') {
                if (hasDot || hasExponent) return false;

                if (i == chs.length - 1 && !hasFrontNum) return false;

                hasDot = true;
            } else if (c == 'e') {
                if (i == chs.length - 1 || hasExponent || !hasFrontNum) return false;
                hasExponent = true;
            } else {
                return false;
            }
        }

        return true;
    }
}
